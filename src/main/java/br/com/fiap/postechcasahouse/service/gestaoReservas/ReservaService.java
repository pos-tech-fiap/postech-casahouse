package br.com.fiap.postechcasahouse.service.gestaoReservas;


import br.com.fiap.postechcasahouse.DTO.gestaoReservas.ReservaDTO;
import br.com.fiap.postechcasahouse.entity.gestaoQuartos.Quarto;
import br.com.fiap.postechcasahouse.entity.gestaoQuartos.TipoQuarto;
import br.com.fiap.postechcasahouse.entity.gestaoReservas.Reserva;
import br.com.fiap.postechcasahouse.entity.gestaoServicos.Item;
import br.com.fiap.postechcasahouse.entity.gestaoServicos.Servico;
import br.com.fiap.postechcasahouse.repository.gestaoQuartos.IQuartoRepository;
import br.com.fiap.postechcasahouse.repository.gestaoQuartos.ITipoQuartoRepository;
import br.com.fiap.postechcasahouse.repository.gestaoReservas.IReservaRepository;
import br.com.fiap.postechcasahouse.repository.gestaoServicos.ItemRepository;
import br.com.fiap.postechcasahouse.repository.gestaoServicos.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ReservaService {

    @Autowired
    private IReservaRepository reservaRepository;

    @Autowired
    private IQuartoRepository quartoRepository;

    @Autowired
    private ServicoRepository servicoRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private ITipoQuartoRepository tipoQuartoRepository;

    @Transactional(readOnly = true)
    public Page<ReservaDTO> findAll(PageRequest pageRequest) {
        Page<Reserva> reservas = reservaRepository.findAll(pageRequest);

        return reservas.map(reserva -> new ReservaDTO(reserva, reserva.getQuartos(),
                reserva.getServicos().stream().map(Servico::getId).collect(Collectors.toList()),
                reserva.getItens())
        );
    }

    @Transactional(readOnly = true)
    public ReservaDTO findById(UUID id) {
        var reserva = reservaRepository.findById(id).orElseThrow(() -> new RuntimeException("Reserva não encontrada"));

        return new ReservaDTO(reserva, reserva.getQuartos(),
                reserva.getServicos().stream().map(Servico::getId).collect(Collectors.toList()),
                reserva.getItens()
        );
    }

    @Transactional
    public ReservaDTO save(ReservaDTO reservaDTO) {
        try {
            validarReserva(reservaDTO);

            Reserva reserva = new Reserva();
            mapperDtoToEntity(reservaDTO, reserva);
            var reservaSaved = reservaRepository.save(reserva);

            return new ReservaDTO(reservaSaved, reservaSaved.getQuartos(),
                    reservaSaved.getServicos().stream().map(Servico::getId).collect(Collectors.toList()), reservaSaved.getItens());
        } catch (Exception e) {
            throw new RuntimeException("Falha ao criar reserva: " + e);
        }
    }

    @Transactional
    public ReservaDTO update(UUID id, ReservaDTO reservaDTO) {
        try {
            validarReserva(reservaDTO);

            Reserva reserva = reservaRepository.getOne(id);
            mapperDtoToEntity(reservaDTO, reserva);
            var reservaSaved = reservaRepository.save(reserva);

            return new ReservaDTO(reservaSaved, reservaSaved.getQuartos(),
                    reservaSaved.getServicos().stream().map(Servico::getId).collect(Collectors.toList()), reservaSaved.getItens());
        } catch (NoSuchElementException e) {
            throw new RuntimeException("Reserva não encontrada, id: " + id);
        }
    }

    public void delete(UUID id) {
        try {
            reservaRepository.deleteById(id);
        } catch (NoSuchElementException e) {
            throw new RuntimeException("Reserva não encontrada, id: " + id);
        }
    }

    private void validarReserva(ReservaDTO reservaDTO) {
        if (reservaDTO.getDataEntrada().isAfter(reservaDTO.getDataSaida())) {
            throw new RuntimeException("Data de entrada não pode ser maior que a data de saída");
        }

        if (reservaDTO.getQuartos().isEmpty()) {
            throw new RuntimeException("Deve ser informado ao menos um quarto");
        }

        if (reservaDTO.getQuantidadePessoas() <= 0) {
            throw new RuntimeException("Quantidade de pessoas deve ser maior que zero");
        }

//        List<Quarto> quartos = quartoRepository.findAllById(reservaDTO.getQuartos());
//        List<UUID> tipoQuartoIdList = quartos.stream().map(Quarto::getTipoQuartoId).collect(Collectors.toList());
//        List<TipoQuarto> tipoQuartos = tipoQuartoRepository.findAllById(tipoQuartoIdList);
//        if (tipoQuartos.stream().mapToInt(TipoQuarto::getTotPessoas).sum() <= reservaDTO.getQuantidadePessoas()) {
//            throw new RuntimeException("Quantidade de pessoas maior que a capacidade dos quartos");
//        }

        reservaRepository.findByQuartosInAndDataEntradaLessThanEqualAndDataSaidaGreaterThanEqual(
                reservaDTO.getQuartos(), reservaDTO.getDataSaida(), reservaDTO.getDataEntrada())
                .ifPresent(reserva -> {
                    throw new RuntimeException("Quarto já reservado para o período informado");
                });
    }

    private void mapperDtoToEntity(ReservaDTO dto, Reserva entity) {
        List<Servico> servicoList = new ArrayList<>();
        List<Item> itemList = new ArrayList<>();

        entity.setIdCliente(dto.getIdCliente());
        entity.setDataEntrada(dto.getDataEntrada());
        entity.setDataSaida(dto.getDataSaida());
        entity.setQuantidadePessoas(dto.getQuantidadePessoas());
        entity.setValorTotal(dto.getValorTotal());

        for (UUID quartoId : dto.getQuartos()) {
            Quarto quarto = quartoRepository.getOne(quartoId);
            entity.getQuartos().add(quarto.getId());
        }

        for (UUID servicoId : dto.getServicos()) {
            Servico servico = servicoRepository.getOne(servicoId);
            servicoList.add(servico);
        }
        entity.setServicos(servicoList);

        for (UUID itemId : dto.getItens()) {
            Item item = itemRepository.getOne(itemId);
            itemList.add(item);
        }
        entity.setItens(itemList.stream().map(Item::getId).collect(Collectors.toList()));
    }
}
