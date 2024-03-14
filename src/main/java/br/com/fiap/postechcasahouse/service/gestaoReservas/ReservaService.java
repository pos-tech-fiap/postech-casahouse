package br.com.fiap.postechcasahouse.service.gestaoReservas;


import br.com.fiap.postechcasahouse.DTO.gestaoReservas.ReservaDTO;
import br.com.fiap.postechcasahouse.entity.gestaoQuartos.Quarto;
import br.com.fiap.postechcasahouse.entity.gestaoReservas.Reserva;
import br.com.fiap.postechcasahouse.entity.gestaoServicos.Servico;
import br.com.fiap.postechcasahouse.repository.gestaoQuartos.IQuartoRepository;
import br.com.fiap.postechcasahouse.repository.gestaoReservas.IReservaRepository;
import br.com.fiap.postechcasahouse.repository.gestaoServicos.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional(readOnly = true)
    public Page<ReservaDTO> findAll(PageRequest pageRequest) {
        Page<Reserva> reservas = reservaRepository.findAll(pageRequest);

        return reservas.map(reserva -> new ReservaDTO(reserva, reserva.getQuartos(), reserva.getServicos().stream().map(Servico::getId).collect(Collectors.toList())));
    }

    @Transactional(readOnly = true)
    public ReservaDTO findById(UUID id) {
        var reserva = reservaRepository.findById(id).orElseThrow(() -> new RuntimeException("Reserva não encontrada"));

        return new ReservaDTO(reserva, reserva.getQuartos(), reserva.getServicos().stream().map(Servico::getId).collect(Collectors.toList()));
    }

    @Transactional
    public ReservaDTO save(ReservaDTO reservaDTO) {
        try {
            Reserva reserva = new Reserva();
            mapperDtoToEntity(reservaDTO, reserva);
            var reservaSaved = reservaRepository.save(reserva);

            return new ReservaDTO(reservaSaved, reservaSaved.getQuartos(), reservaSaved.getServicos().stream().map(Servico::getId).collect(Collectors.toList()));
        } catch (Exception e) {
            throw new RuntimeException("Falha ao criar reserva: " + e);
        }
    }

    @Transactional
    public ReservaDTO update(UUID id, ReservaDTO reservaDTO) {
        try {
            Reserva reserva = reservaRepository.getOne(id);
            mapperDtoToEntity(reservaDTO, reserva);
            var reservaSaved = reservaRepository.save(reserva);

            return new ReservaDTO(reservaSaved, reservaSaved.getQuartos(), reservaSaved.getServicos().stream().map(Servico::getId).collect(Collectors.toList()));
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

    private void mapperDtoToEntity(ReservaDTO dto, Reserva entity) {
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
            entity.getServicos().add(servico);
        }
    }

}
