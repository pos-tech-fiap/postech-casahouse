package br.com.fiap.postechcasahouse.service.gestaoQuartos;

import br.com.fiap.postechcasahouse.DTO.gestaoQuartos.LocalidadeDTO;
import br.com.fiap.postechcasahouse.entity.gestaoQuartos.Amenidades;
import br.com.fiap.postechcasahouse.entity.gestaoQuartos.Localidade;
import br.com.fiap.postechcasahouse.repository.gestaoQuartos.ILocalidadeRepository;
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

    @Transactional(readOnly = true)
    public Page<LocalidadeDTO> findAll(PageRequest pageRequest) {
        Page<Localidade> localidades = localidadeRepository.findAll(pageRequest);
        return localidades.map(LocalidadeDTO::new);
    }

    @Transactional(readOnly = true)
    public LocalidadeDTO findById(UUID id) {
        var localidades = localidadeRepository.findById(id).orElseThrow(() -> new RuntimeException("Localidade não encontrada"));
        return new LocalidadeDTO(localidades);
    }

    @Transactional
    public LocalidadeDTO save(LocalidadeDTO personDTO) {
        Localidade localidade = new Localidade();
        mapperDtoToEntity(personDTO, localidade);
        return new LocalidadeDTO(localidadeRepository.save(localidade));
    }

    @Transactional
    public LocalidadeDTO update(UUID id, LocalidadeDTO LocalidadeDTO) {
        try {
            Localidade Localidade = localidadeRepository.getOne(id);
            mapperDtoToEntity(LocalidadeDTO, Localidade);
            return new LocalidadeDTO(localidadeRepository.save(Localidade));
        } catch (NoSuchElementException e) {
            throw new RuntimeException("Localidade não encontrada, id: " + id);
        }
    }

    public void delete(UUID id) {
        try {
            localidadeRepository.deleteById(id);
        } catch (NoSuchElementException e) {
            throw new RuntimeException("Localidade não encontrada, id: " + id);
        }
    }

//    @Transactional(readOnly = true)
//    public List<LocalidadeDTO> find(String cep, String rua, String cidade, String estado) {
//        List<Localidade> localidades = new ArrayList<>();
//        if (cep != null) {
//            localidades.addAll(localidadeRepository.findByCEP(cep));
//        }
//        if (rua != null) {
//            localidades.addAll(localidadeRepository.findByRua(rua));
//        }
//
//        if (cidade != null) {
//            localidades.addAll(localidadeRepository.findByCidade(cidade));
//        }
//
//        if (estado != null) {
//            localidades.addAll(localidadeRepository.findByEstado(estado));
//        }
//
//        return localidades.stream().map(person -> new LocalidadeDTO((Localidade) localidades)).collect(Collectors.toList());
//    }

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
