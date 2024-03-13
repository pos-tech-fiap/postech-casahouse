package br.com.fiap.postechcasahouse.service.gestaoQuartos;

import br.com.fiap.postechcasahouse.DTO.gestaoQuartos.QuartoDTO;
import br.com.fiap.postechcasahouse.entity.gestaoQuartos.Quarto;
import br.com.fiap.postechcasahouse.repository.gestaoQuartos.IQuartoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;
import java.util.UUID;

@Service
public class QuartoService {
    @Autowired
    private IQuartoRepository quartoRepository;
    private final Logger logger = LoggerFactory.getLogger(QuartoService.class);


    @Transactional(readOnly = true)
    public Page<QuartoDTO> findAll(PageRequest pageRequest) {
        try {
            Page<Quarto> quarto = quartoRepository.findAll(pageRequest);
            logger.info("Quartos encontrados: {}", quarto.getTotalElements());
            return quarto.map(QuartoDTO::new);
        } catch (RuntimeException e) {
            logger.error("Falha ao buscar Quartos : {}", e);
            throw new RuntimeException(e);
        }
    }

    @Transactional(readOnly = true)
    public QuartoDTO findById(UUID id) {
        var quarto = quartoRepository.findById(id).orElseThrow(() -> new RuntimeException("Quarto não encontrado"));
        logger.info("Quartos encontrados: {}", quarto);
        return new QuartoDTO(quarto);
    }

    @Transactional
    public QuartoDTO save(QuartoDTO quartoDTO) {
        try {
            Quarto quarto = new Quarto();
            mapperDtoToEntity(quartoDTO, quarto);
            logger.info("Quarto criados: {}", quarto);
            return new QuartoDTO(quartoRepository.save(quarto));
        } catch (Exception e) {
            logger.error("Falha ao criar Quartos : {}", e);
            throw new RuntimeException(e);
        }
    }

    @Transactional
    public QuartoDTO update(UUID id, QuartoDTO quartoDTO) {
        try {
            Quarto quarto = quartoRepository.getOne(id);
            mapperDtoToEntity(quartoDTO, quarto);
            logger.info("Quartos atualizados com sucesso: {}", quarto);
            return new QuartoDTO(quartoRepository.save(quarto));
        } catch (NoSuchElementException e) {
            logger.error("Falha ao atualizar Quartos : {}", e);
            throw new RuntimeException("Quarto não encontrado, id: " + id);
        }
    }

    public void delete(UUID id) {
        try {
            quartoRepository.deleteById(id);
            logger.info("Quarto removido com sucesso: {}");

        } catch (NoSuchElementException e) {
            logger.error("Falha ao  remover Quartos: {}", e);
            throw new RuntimeException("Quarto não encontrado, id: " + id);
        }
    }

    private void mapperDtoToEntity(QuartoDTO dto, Quarto quarto) {
        quarto.setNome(dto.getNome());
        quarto.setPredioId(dto.getPredioId());
        quarto.getTipoQuartoId();
    }

}
