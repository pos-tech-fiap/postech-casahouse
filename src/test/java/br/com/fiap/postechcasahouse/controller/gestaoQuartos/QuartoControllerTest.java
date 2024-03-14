package br.com.fiap.postechcasahouse.controller.gestaoQuartos;

import br.com.fiap.postechcasahouse.DTO.gestaoQuartos.QuartoDTO;
import br.com.fiap.postechcasahouse.service.gestaoQuartos.QuartoService;
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

import java.util.Collections;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class QuartoControllerTest {
    @Mock
    private QuartoService quartoService;

    @InjectMocks
    private QuartoController quartoController;

    @Test
    void testFindAllSuccess() {
        // Mocking
        PageRequest pageRequest = PageRequest.of(0, 10);
        Page<QuartoDTO> page = new PageImpl<>(Collections.emptyList());
        when(quartoService.findAll(pageRequest)).thenReturn(page);

        // Execution
        ResponseEntity<Page<QuartoDTO>> responseEntity = quartoController.findAll(0, 10);

        // Verification
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(page, responseEntity.getBody());
        verify(quartoService, times(1)).findAll(pageRequest);
    }

    @Test
    void testFindByIdSuccess() {
        // Mocking
        UUID id = UUID.randomUUID();
        QuartoDTO quartoDTO = new QuartoDTO( id, "Suite 14",  id,id);
        when(quartoService.findById(id)).thenReturn(quartoDTO);

        // Execution
        ResponseEntity<QuartoDTO> responseEntity = quartoController.findById(id);

        // Verification
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(quartoDTO, responseEntity.getBody());
        verify(quartoService, times(1)).findById(id);
    }

    @Test
    void testSaveSuccess() {
        // Mocking
        UUID id = UUID.randomUUID();
        QuartoDTO quartoDTO = new QuartoDTO( id, "Suite 14",  id,id);
        when(quartoService.save(quartoDTO)).thenReturn(quartoDTO);

        // Execution
        ResponseEntity<QuartoDTO> responseEntity = quartoController.save(quartoDTO);

        // Verification
        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals(quartoDTO, responseEntity.getBody());
        verify(quartoService, times(1)).save(quartoDTO);
    }

    @Test
    void testUpdateSuccess() {
        // Mocking
        UUID id = UUID.randomUUID();
        QuartoDTO quartoDTO = new QuartoDTO( id, "Suite 14",  id,id);
        when(quartoService.update(id,quartoDTO)).thenReturn(quartoDTO);

        // Execution
        ResponseEntity<QuartoDTO> responseEntity = quartoController.update(id, quartoDTO);

        // Verification
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(quartoDTO, responseEntity.getBody());
        verify(quartoService, times(1)).update(id, quartoDTO);
    }

    @Test
    void testDeleteSuccess() {
        // Mocking
        UUID id = UUID.randomUUID();

        // Execution
        ResponseEntity<String> responseEntity = quartoController.delete(id);

        // Verification
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals("Quarto removido com sucesso!", responseEntity.getBody());
        verify(quartoService, times(1)).delete(id);
    }
}
