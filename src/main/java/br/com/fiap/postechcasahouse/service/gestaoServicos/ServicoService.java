package br.com.fiap.postechcasahouse.service.gestaoServicos;

import br.com.fiap.postechcasahouse.DTO.gestaoServicos.ServicoDTO;
import br.com.fiap.postechcasahouse.entity.gestaoServicos.Servico;
import br.com.fiap.postechcasahouse.repository.gestaoServicos.ServicoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ServicoService {

    @Autowired
    private ServicoRepository servicoRepository;

    public ServicoDTO save(ServicoDTO servicoDTO) {
        Servico servico = new Servico();
        mapperDtoToEntity(servicoDTO, servico);
        servicoRepository.save(servico);

        return new ServicoDTO(servico);
    }

    private void mapperDtoToEntity(ServicoDTO dto, Servico servico) {
        servico.setNome(dto.getNome());
        servico.setValor(dto.getValor());
    }
}
