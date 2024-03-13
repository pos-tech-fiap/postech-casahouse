package br.com.fiap.postechcasahouse.controller.gestaoQuartos;

import br.com.fiap.postechcasahouse.DTO.gestaoQuartos.PredioDTO;
import br.com.fiap.postechcasahouse.entity.gestaoQuartos.Amenidades;
import br.com.fiap.postechcasahouse.service.gestaoQuartos.PredioService;
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
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
public class PredioControllerTest {
    @Mock
    private PredioService predioService;

    @InjectMocks
    private PredioController predioController;

    @Test
    void testFindAllSuccess() {
        // Mocking
        PageRequest pageRequest = PageRequest.of(0, 10);
        Page<PredioDTO> page = new PageImpl<>(Collections.emptyList());
        when(predioService.findAll(pageRequest)).thenReturn(page);

        // Execution
        ResponseEntity<Page<PredioDTO>> responseEntity = predioController.findAll(0, 10);

        // Verification
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(page, responseEntity.getBody());
        verify(predioService, times(1)).findAll(pageRequest);
    }

    @Test
    void testFindByIdSuccess() {
        // Mocking
        UUID id = UUID.randomUUID();
        UUID localidadeId = UUID.randomUUID();
        PredioDTO predioDTO = new PredioDTO( id, "Predio 1",  localidadeId);
        when(predioService.findById(id)).thenReturn(predioDTO);

        // Execution
        ResponseEntity<PredioDTO> responseEntity = predioController.findById(id);

        // Verification
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(predioDTO, responseEntity.getBody());
        verify(predioService, times(1)).findById(id);
    }

    @Test
    void testSaveSuccess() {
        // Mocking
        UUID id = UUID.randomUUID();
        UUID localidadeId = UUID.randomUUID();
        PredioDTO predioDTO = new PredioDTO( id, "Predio 1",  localidadeId);
        when(predioService.save(predioDTO)).thenReturn(predioDTO);

        // Execution
        ResponseEntity<PredioDTO> responseEntity = predioController.save(predioDTO);

        // Verification
        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals(predioDTO, responseEntity.getBody());
        verify(predioService, times(1)).save(predioDTO);
    }

    @Test
    void testUpdateSuccess() {
        // Mocking
        UUID id = UUID.randomUUID();
        UUID localidadeId = UUID.randomUUID();
        PredioDTO predioDTO = new PredioDTO( id, "Predio 1",  localidadeId);
        when(predioService.update(id, predioDTO)).thenReturn(predioDTO);

        // Execution
        ResponseEntity<PredioDTO> responseEntity = predioController.update(id, predioDTO);

        // Verification
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(predioDTO, responseEntity.getBody());
        verify(predioService, times(1)).update(id, predioDTO);
    }

    @Test
    void testDeleteSuccess() {
        // Mocking
        UUID id = UUID.randomUUID();

        // Execution
        ResponseEntity<String> responseEntity = predioController.delete(id);

        // Verification
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals("Predio removido com sucesso!", responseEntity.getBody());
        verify(predioService, times(1)).delete(id);
    }
}
