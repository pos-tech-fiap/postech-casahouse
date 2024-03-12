package br.com.fiap.postechcasahouse.service.gestaoServicos;

import br.com.fiap.postechcasahouse.DTO.gestaoServicos.ServicoDTO;
import br.com.fiap.postechcasahouse.entity.gestaoServicos.Servico;
import br.com.fiap.postechcasahouse.repository.gestaoServicos.ServicoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.UUID;

@Service
@Transactional
public class ServicoService {

    @Autowired
    private ServicoRepository servicoRepository;

    public Page<ServicoDTO> findAll(PageRequest pageRequest) {
        Page<Servico> servicoPage = servicoRepository.findAll(pageRequest);
        return servicoPage.map(ServicoDTO::new);
    }

    public ServicoDTO save(ServicoDTO servicoDTO) {
        Servico servico = new Servico();
        mapperDtoToEntity(servicoDTO, servico);
        servicoRepository.save(servico);

        return new ServicoDTO(servico);
    }

    public ServicoDTO update(UUID id, ServicoDTO servicoDTO) {
        try {
            Servico servico = servicoRepository.getOne(id);
            mapperDtoToEntity(servicoDTO, servico);
            return new ServicoDTO(servicoRepository.save(servico));
        } catch (NoSuchElementException e) {
            throw new RuntimeException("Serviço não encontrado, id: " + id);
        }
    }

    private void mapperDtoToEntity(ServicoDTO dto, Servico servico) {
        servico.setNome(dto.getNome());
        servico.setValor(dto.getValor());
    }
}
