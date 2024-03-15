package br.com.fiap.postechcasahouse.controller.gestaoUsuarios;

import br.com.fiap.postechcasahouse.DTO.gestaoUsuarios.UsuarioDTO;
import br.com.fiap.postechcasahouse.service.gestaoUsuarios.UsuarioService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UsuarioControllerTest {
    @Mock
    private UsuarioService usuarioService;

    @InjectMocks
    private UsuarioController usuarioController;

    @Test
    void testFindAllSuccess() {
        // Mocking
        PageRequest pageRequest = PageRequest.of(0, 10);
        Page<UsuarioDTO> page = new PageImpl<>(Collections.emptyList());
        when(usuarioService.findAll(pageRequest)).thenReturn(page);

        // Execution
        ResponseEntity<Page<UsuarioDTO>> responseEntity = usuarioController.findAll(0, 10);

        // Verification
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(page, responseEntity.getBody());
        verify(usuarioService, times(1)).findAll(pageRequest);
    }

    @Test
    void testFindByIdSuccess() {
        // Mocking
        UUID id = UUID.randomUUID();
        UsuarioDTO usuarioDTO = new UsuarioDTO(
                id,
                "Nome do Usuário",
                "123.456.789-00", // Exemplo de CPF
                "Origem do Usuário",
                "Número do Passaporte",
                LocalDateTime.of(1990, 1, 1, 0, 0), // Exemplo de data de nascimento
                "Endereço do Usuário",
                "Telefone do Usuário",
                "email@example.com"
        );
        when(usuarioService.findById(id)).thenReturn(usuarioDTO);

        // Execution
        ResponseEntity<UsuarioDTO> responseEntity = usuarioController.findById(id);

        // Verification
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(usuarioDTO, responseEntity.getBody());
        verify(usuarioService, times(1)).findById(id);
    }

    @Test
    void testSaveSuccess() {
        // Mocking
        UUID id = UUID.randomUUID();
        UsuarioDTO usuarioDTO = new UsuarioDTO(
                id,
                "Nome do Usuário",
                "123.456.789-00", // Exemplo de CPF
                "Origem do Usuário",
                "Número do Passaporte",
                LocalDateTime.of(1990, 1, 1, 0, 0), // Exemplo de data de nascimento
                "Endereço do Usuário",
                "Telefone do Usuário",
                "email@example.com"
        );
        when(usuarioService.save(usuarioDTO)).thenReturn(usuarioDTO);

        // Execution
        ResponseEntity<UsuarioDTO> responseEntity = usuarioController.save(usuarioDTO);

        // Verification
        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals(usuarioDTO, responseEntity.getBody());
        verify(usuarioService, times(1)).save(usuarioDTO);
    }

    @Test
    void testUpdateSuccess() {
        // Mocking
        UUID id = UUID.randomUUID();
        UsuarioDTO usuarioDTO = new UsuarioDTO(
                id,
                "Nome do Usuário",
                "123.456.789-00", // Exemplo de CPF
                "Origem do Usuário",
                "Número do Passaporte",
                LocalDateTime.of(1990, 1, 1, 0, 0), // Exemplo de data de nascimento
                "Endereço do Usuário",
                "Telefone do Usuário",
                "email@example.com"
        );
        when(usuarioService.update(id,usuarioDTO)).thenReturn(usuarioDTO);

        // Execution
        ResponseEntity<UsuarioDTO> responseEntity = usuarioController.update(id, usuarioDTO);

        // Verification
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(usuarioDTO, responseEntity.getBody());
        verify(usuarioService, times(1)).update(id, usuarioDTO);
    }

    @Test
    void testDeleteSuccess() {
        // Mocking
        UUID id = UUID.randomUUID();

        // Execution
        ResponseEntity<String> responseEntity = usuarioController.delete(id);

        // Verification
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals("Usuario removido com sucesso!", responseEntity.getBody());
        verify(usuarioService, times(1)).delete(id);
    }
}
