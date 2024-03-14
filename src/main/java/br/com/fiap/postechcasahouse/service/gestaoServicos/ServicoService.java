package br.com.fiap.postechcasahouse.service.gestaoServicos;

import br.com.fiap.postechcasahouse.DTO.gestaoServicos.ServicoDTO;
import br.com.fiap.postechcasahouse.entity.gestaoServicos.Servico;
import br.com.fiap.postechcasahouse.repository.gestaoServicos.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;
import java.util.UUID;

@Service
public class ServicoService {

    @Autowired
    private ServicoRepository servicoRepository;

    @Transactional(readOnly = true)
    public Page<ServicoDTO> findAll(PageRequest pageRequest) {
        Page<Servico> servicoPage = servicoRepository.findAll(pageRequest);
        return servicoPage.map(ServicoDTO::new);
    }

    @Transactional(readOnly = true)
    public ServicoDTO findById(UUID id) {
        var servico = servicoRepository.findById(id).orElseThrow(() -> new RuntimeException("Serviço não encontrado."));
        return new ServicoDTO(servico);
    }

    @Transactional
    public ServicoDTO save(ServicoDTO servicoDTO) {
        Servico servico = new Servico();
        mapperDtoToEntity(servicoDTO, servico);
        servicoRepository.save(servico);

        return new ServicoDTO(servico);
    }

    @Transactional
    public ServicoDTO update(UUID id, ServicoDTO servicoDTO) {
        try {
            Servico servico = servicoRepository.getOne(id);
            mapperDtoToEntity(servicoDTO, servico);
            return new ServicoDTO(servicoRepository.save(servico));
        } catch (NoSuchElementException e) {
            throw new RuntimeException("Serviço não encontrado, id: " + id);
        }
    }

    public void delete(UUID id) {
        try {
            servicoRepository.deleteById(id);
        } catch (NoSuchElementException e) {
            throw new RuntimeException("Serviço não encontrado, id: " + id);
        }
    }

    private void mapperDtoToEntity(ServicoDTO dto, Servico servico) {
        servico.setNome(dto.getNome());
        servico.setValor(dto.getValor());
    }
}
