package br.com.fiap.postechcasahouse.service.gestaoUsuarios;

import br.com.fiap.postechcasahouse.DTO.gestaoUsuarios.UsuarioDTO;
import br.com.fiap.postechcasahouse.entity.gestaoUsuarios.Usuario;
import br.com.fiap.postechcasahouse.repository.gestaoUsuarios.IUsuarioRepository;
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
public class UsuarioService {
    @Autowired
    private IUsuarioRepository usuarioRepository;
    private final Logger logger = LoggerFactory.getLogger(UsuarioService.class);


    @Transactional(readOnly = true)
    public Page<UsuarioDTO> findAll(PageRequest pageRequest) {
        try {
            Page<Usuario> usuario = usuarioRepository.findAll(pageRequest);
            logger.info("Usuarios encontrados: {}", usuario.getTotalElements());
            return usuario.map(UsuarioDTO::new);
        } catch (RuntimeException e) {
            logger.error("Falha ao buscar Usuarios : {}", e);
            throw new RuntimeException(e);
        }
    }

    @Transactional(readOnly = true)
    public UsuarioDTO findById(UUID id) {
        var usuario = usuarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuario não encontrado"));
        logger.info("Usuarios encontrados: {}", usuario);
        return new UsuarioDTO(usuario);
    }

    @Transactional
    public UsuarioDTO save(UsuarioDTO usuarioDTO) {
        try {
            Usuario usuario = new Usuario();
            mapperDtoToEntity(usuarioDTO, usuario);
            logger.info("Usuario criados: {}", usuario);
            return new UsuarioDTO(usuarioRepository.save(usuario));
        } catch (Exception e) {
            logger.error("Falha ao criar Usuarios : {}", e);
            throw new RuntimeException(e);
        }
    }

    @Transactional
    public UsuarioDTO update(UUID id, UsuarioDTO usuarioDTO) {
        try {
            Usuario usuario = usuarioRepository.getOne(id);
            mapperDtoToEntity(usuarioDTO, usuario);
            logger.info("Usuarios atualizados com sucesso: {}", usuario);
            return new UsuarioDTO(usuarioRepository.save(usuario));
        } catch (NoSuchElementException e) {
            logger.error("Falha ao atualizar Usuarios : {}", e);
            throw new RuntimeException("Usuario não encontrado, id: " + id);
        }
    }

    public void delete(UUID id) {
        try {
            usuarioRepository.deleteById(id);
            logger.info("Usuario removido com sucesso: {}");

        } catch (NoSuchElementException e) {
            logger.error("Falha ao  remover Usuario: {}", e);
            throw new RuntimeException("Usuario não encontrado, id: " + id);
        }
    }

    private void mapperDtoToEntity(UsuarioDTO dto, Usuario usuario) {
        usuario.setNome(dto.getNome());
        usuario.setCPF(dto.getCPF());
        usuario.setEmail(dto.getEmail());
        usuario.setTelefone(dto.getTelefone());
        usuario.setDataNascimento(dto.getDataNascimento());
        usuario.setEndereco(dto.getEndereco());
        usuario.setOrigem(dto.getOrigem());
        usuario.setPassaporte(dto.getPassaporte());
    }

}
