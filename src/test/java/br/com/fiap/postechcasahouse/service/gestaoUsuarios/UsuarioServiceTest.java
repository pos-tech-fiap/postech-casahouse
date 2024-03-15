package br.com.fiap.postechcasahouse.service.gestaoUsuarios;

import br.com.fiap.postechcasahouse.DTO.gestaoUsuarios.UsuarioDTO;
import br.com.fiap.postechcasahouse.entity.gestaoUsuarios.Usuario;
import br.com.fiap.postechcasahouse.repository.gestaoUsuarios.IUsuarioRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@ExtendWith(MockitoExtension.class)
public class UsuarioServiceTest {

    @Mock
    private IUsuarioRepository usuarioRepository;
    @InjectMocks
    private UsuarioService usuarioService;
    @Test
    public void testFindAll_success() {
        Page<Usuario> mockPage = Page.empty();
        Mockito.when(usuarioRepository.findAll(Mockito.any(PageRequest.class))).thenReturn(mockPage);

        Page<UsuarioDTO> actualPage = usuarioService.findAll(PageRequest.of(0, 10));

        assertNotNull(actualPage);
        assertEquals(0, actualPage.getTotalElements());
    }

    @Test
    public void testFindById_success() throws Exception {
        UUID mockId = UUID.randomUUID();
        Usuario mockUsuario = new Usuario();
        mockUsuario.setId(mockId);
        Mockito.when(usuarioRepository.findById(mockId)).thenReturn(Optional.of(mockUsuario));

        UsuarioDTO actualDTO = usuarioService.findById(mockId);

        assertNotNull(actualDTO);
        assertEquals(mockId, actualDTO.getId());
    }

    @Test
    public void testFindById_notFound() throws Exception {
        UUID mockId = UUID.randomUUID();
        Usuario usuario = new Usuario(
                mockId,
                "Nome do Usuário",
                "123.456.789-00", // Exemplo de CPF
                "Origem do Usuário",
                "Número do Passaporte",
                LocalDateTime.of(1990, 1, 1, 0, 0),
                "Endereço do Usuário",
                "Telefone do Usuário",
                "email@example.com"
        );
        Mockito.when(usuarioRepository.findById(mockId)).thenReturn(Optional.of(usuario));

        usuarioService.findById(mockId);
    }
    @Test
    public void testSave_success() throws Exception {
        // Create mock DTO and user
        UUID mockId = UUID.randomUUID();
        Usuario usuario = new Usuario(
                mockId,
                "Nome do Usuário",
                "123.456.789-00", // Exemplo de CPF
                "Origem do Usuário",
                "Número do Passaporte",
                LocalDateTime.of(1990, 1, 1, 0, 0),
                "Endereço do Usuário",
                "Telefone do Usuário",
                "email@example.com"
        );
        UsuarioDTO usuarioDTO = new UsuarioDTO(
                mockId,
                "Nome do Usuário",
                "123.456.789-00", // Exemplo de CPF
                "Origem do Usuário",
                "Número do Passaporte",
                LocalDateTime.of(1990, 1, 1, 0, 0),
                "Endereço do Usuário",
                "Telefone do Usuário",
                "email@example.com"
        );

        Mockito.when(usuarioRepository.save(Mockito.any(Usuario.class))).thenReturn(usuario);

        UsuarioDTO actualDTO = usuarioService.save(usuarioDTO);

        assertNotNull(actualDTO);
    }
}