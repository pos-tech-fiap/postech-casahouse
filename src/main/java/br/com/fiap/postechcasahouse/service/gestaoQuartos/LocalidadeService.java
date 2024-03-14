package br.com.fiap.postechcasahouse.service.gestaoQuartos;

import br.com.fiap.postechcasahouse.DTO.gestaoQuartos.LocalidadeDTO;
import br.com.fiap.postechcasahouse.entity.gestaoQuartos.Amenidades;
import br.com.fiap.postechcasahouse.entity.gestaoQuartos.Localidade;
import br.com.fiap.postechcasahouse.repository.gestaoQuartos.ILocalidadeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class LocalidadeService {
    @Autowired
    private ILocalidadeRepository localidadeRepository;
    private final Logger logger = LoggerFactory.getLogger(LocalidadeService.class);


    @Transactional(readOnly = true)
    public Page<LocalidadeDTO> findAll(PageRequest pageRequest) {
        try {
            Page<Localidade> localidades = localidadeRepository.findAll(pageRequest);
            logger.info("Localidades encontradas: {}", localidades.getTotalElements());
            return localidades.map(LocalidadeDTO::new);
        }catch (RuntimeException e){
            logger.error("Falha ao buscar localidades : {}", e);
            throw new RuntimeException(e);
        }
    }

    @Transactional(readOnly = true)
    public LocalidadeDTO findById(UUID id) {
            var localidades = localidadeRepository.findById(id).orElseThrow(() -> new RuntimeException("Localidade não encontrada"));
            logger.info("Localidades encontradas: {}", localidades);
            return new LocalidadeDTO(localidades);
    }

    @Transactional
    public LocalidadeDTO save(LocalidadeDTO personDTO) {
        try {
            Localidade localidade = new Localidade();
            mapperDtoToEntity(personDTO, localidade);
            logger.info("Localidades criadas: {}", localidade);
            return new LocalidadeDTO(localidadeRepository.save(localidade));
        } catch (Exception e) {
            logger.error("Falha ao criar localidades : {}", e);
            throw new RuntimeException(e);
        }
    }

    @Transactional
    public LocalidadeDTO update(UUID id, LocalidadeDTO LocalidadeDTO) {
        try {
            Localidade localidade = localidadeRepository.getOne(id);
            mapperDtoToEntity(LocalidadeDTO, localidade);
            logger.info("Localidades atualizada com sucesso: {}", localidade);
            return new LocalidadeDTO(localidadeRepository.save(localidade));
        } catch (NoSuchElementException e) {
            logger.error("Falha ao atualizar localidades : {}", e);
            throw new RuntimeException("Localidade não encontrada, id: " + id);
        }
    }

    public void delete(UUID id) {
        try {
            localidadeRepository.deleteById(id);
            logger.info("Localidades removida com sucesso: {}");

        } catch (NoSuchElementException e) {
            logger.error("Falha ao  remover localidades: {}",e);
            throw new RuntimeException("Localidade não encontrada, id: " + id);
        }
    }

    private void mapperDtoToEntity(LocalidadeDTO dto, Localidade localidade) {
        localidade.setNome(dto.getNome());
        localidade.setAmenidades(gerarAmenidadesAleatorias());
        localidade.setCep(dto.getCep());
        localidade.setCidade(dto.getCidade());
        localidade.setEstado(dto.getEstado());
        localidade.setRua(dto.getRua());
    }

    private Set<Amenidades> gerarAmenidadesAleatorias() {
        Set<Amenidades> amenidades = new HashSet<>();
        Amenidades[] todasAmenidades = Amenidades.values();
        Random random = new Random();
        int quantidadeAmenidades = random.nextInt(todasAmenidades.length) + 1;

        for (int i = 0; i < quantidadeAmenidades; i++) {
            int index = random.nextInt(todasAmenidades.length);
            amenidades.add(todasAmenidades[index]);
        }

        return amenidades;
    }

}
