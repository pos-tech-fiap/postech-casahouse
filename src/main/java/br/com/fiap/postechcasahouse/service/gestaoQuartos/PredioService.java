package br.com.fiap.postechcasahouse.service.gestaoQuartos;

import br.com.fiap.postechcasahouse.DTO.gestaoQuartos.PredioDTO;
import br.com.fiap.postechcasahouse.entity.gestaoQuartos.Predio;
import br.com.fiap.postechcasahouse.repository.gestaoQuartos.IPredioRepository;
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
public class PredioService {
    private final Logger logger = LoggerFactory.getLogger(PredioService.class);
    @Autowired
    private IPredioRepository predioRepository;

    @Transactional(readOnly = true)
    public Page<PredioDTO> findAll(PageRequest pageRequest) {
        try {
            Page<Predio> predio = predioRepository.findAll(pageRequest);
            logger.info("Predios encontradas: {}", predio.getTotalElements());
            return predio.map(PredioDTO::new);
        } catch (RuntimeException e) {
            logger.error("Falha ao buscar Predios : {}", e);
            throw new RuntimeException(e);
        }
    }

    @Transactional(readOnly = true)
    public PredioDTO findById(UUID id) {
        var predios = predioRepository.findById(id).orElseThrow(() -> new RuntimeException("Predio não encontrado"));
        logger.info("Predios encontrados: {}", predios);
        return new PredioDTO(predios);
    }

    @Transactional
    public PredioDTO save(PredioDTO predioDTO) {
        try {
            Predio predios = new Predio();
            mapperDtoToEntity(predioDTO, predios);
            logger.info("Predios criados: {}", predios);
            return new PredioDTO(predioRepository.save(predios));
        } catch (Exception e) {
            logger.error("Falha ao criar Predios : {}", e);
            throw new RuntimeException(e);
        }
    }

    @Transactional
    public PredioDTO update(UUID id, PredioDTO predioDTO) {
        try {
            Predio predio = predioRepository.getOne(id);
            mapperDtoToEntity(predioDTO, predio);
            logger.info("Predios atualizados com sucesso: {}", predio);
            return new PredioDTO(predioRepository.save(predio));
        } catch (NoSuchElementException e) {
            logger.error("Falha ao atualizar Predios : {}", e);
            throw new RuntimeException("Predio não encontrada, id: " + id);
        }
    }

    public void delete(UUID id) {
        try {
            predioRepository.deleteById(id);
            logger.info("Predio removido com sucesso: {}");

        } catch (NoSuchElementException e) {
            logger.error("Falha ao  remover Predios: {}", e);
            throw new RuntimeException("Predio não encontrado, id: " + id);
        }
    }

    private void mapperDtoToEntity(PredioDTO dto, Predio predio) {
        predio.setNome(dto.getNome());
        predio.setLocalidadeId(dto.getLocalidadeId());
    }


}
