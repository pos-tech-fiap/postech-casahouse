package br.com.fiap.postechcasahouse.service.gestaoQuartos;

import br.com.fiap.postechcasahouse.DTO.gestaoQuartos.TipoQuartoDTO;
import br.com.fiap.postechcasahouse.entity.gestaoQuartos.Amenidades;
import br.com.fiap.postechcasahouse.entity.gestaoQuartos.Descricao;
import br.com.fiap.postechcasahouse.entity.gestaoQuartos.TipoQuarto;
import br.com.fiap.postechcasahouse.repository.gestaoQuartos.ITipoQuartoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class TipoQuartoService {
    @Autowired
    private ITipoQuartoRepository tipoQuartoRepository;
    private final Logger logger = LoggerFactory.getLogger(TipoQuartoService.class);


    @Transactional(readOnly = true)
    public Page<TipoQuartoDTO> findAll(PageRequest pageRequest) {
        try {
            Page<TipoQuarto> tipoQuarto = tipoQuartoRepository.findAll(pageRequest);
            logger.info("Tipo de quarto encontrados: {}", tipoQuarto.getTotalElements());
            return tipoQuarto.map(TipoQuartoDTO::new);
        } catch (RuntimeException e) {
            logger.error("Falha ao buscar tipo quarto : {}", e);
            throw new RuntimeException(e);
        }
    }

    @Transactional(readOnly = true)
    public TipoQuartoDTO findById(UUID id) {
        var tipoQuarto = tipoQuartoRepository.findById(id).orElseThrow(() -> new RuntimeException("Tipo quarto não encontrado"));
        logger.info("Tipo de quarto encontrados: {}", tipoQuarto);
        return new TipoQuartoDTO(tipoQuarto);
    }

    @Transactional
    public TipoQuartoDTO save(TipoQuartoDTO tipoQuartoDTO) {
        try {
            TipoQuarto tipoQuarto = new TipoQuarto();
            mapperDtoToEntity(tipoQuartoDTO, tipoQuarto);
            logger.info("Tipo de quarto criado: {}", tipoQuarto);
            return new TipoQuartoDTO(tipoQuartoRepository.save(tipoQuarto));
        } catch (Exception e) {
            logger.error("Falha ao criar tipo de quarto : {}", e);
            throw new RuntimeException(e);
        }
    }

    @Transactional
    public TipoQuartoDTO update(UUID id, TipoQuartoDTO tipoQuartoDTO) {
        try {
            TipoQuarto tipoQuarto = tipoQuartoRepository.getOne(id);
            mapperDtoToEntity(tipoQuartoDTO, tipoQuarto);
            logger.info("tipoQuarto atualizada com sucesso: {}", tipoQuarto);
            return new TipoQuartoDTO(tipoQuartoRepository.save(tipoQuarto));
        } catch (NoSuchElementException e) {
            logger.error("Falha ao atualizar o tipo de quarto : {}", e);
            throw new RuntimeException("Tipo de quarto não encontrado, id: " + id);
        }
    }

    public void delete(UUID id) {
        try {
            tipoQuartoRepository.deleteById(id);
            logger.info("Tipo de quarto removido com sucesso: {}");

        } catch (NoSuchElementException e) {
            logger.error("Falha ao  remover tipo de quarto: {}", e);
            throw new RuntimeException("Tipo de quarto não encontrado, id: " + id);
        }
    }

    private void mapperDtoToEntity(TipoQuartoDTO dto, TipoQuarto tipoQuarto) {
        tipoQuarto.setNome(dto.getNome());
        tipoQuarto.setDescricao(gerarDescricaoAleatorias());
        tipoQuarto.setTotBanheiros(dto.getTotBanheiros());
        tipoQuarto.setTotCamas(dto.getTotCamas());
        tipoQuarto.setTotPessoas(dto.getTotPessoas());
        tipoQuarto.setvalorDiaria(dto.getValorDiaria());
    }
    private Set<Descricao> gerarDescricaoAleatorias() {
        Set<Descricao> descricao = new HashSet<>();
        Descricao[] todasDescricao = Descricao.values();
        Random random = new Random();
        int quantidadeDescricao = random.nextInt(todasDescricao.length) + 1;

        for (int i = 0; i < quantidadeDescricao; i++) {
            int index = random.nextInt(todasDescricao.length);
            descricao.add(todasDescricao[index]);
        }

        return descricao;
    }


}
