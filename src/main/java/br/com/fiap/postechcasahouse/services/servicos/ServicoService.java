package br.com.fiap.postechcasahouse.services.servicos;

import br.com.fiap.postechcasahouse.dtos.servicos.ServicoDTO;
import br.com.fiap.postechcasahouse.models.servicos.Servico;
import br.com.fiap.postechcasahouse.repositories.servicos.ServicoRepository;
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
