package br.com.fiap.postechcasahouse.controller.gestaoQuartos;

import br.com.fiap.postechcasahouse.DTO.gestaoQuartos.TipoQuartoDTO;
import br.com.fiap.postechcasahouse.entity.gestaoQuartos.Descricao;
import br.com.fiap.postechcasahouse.service.gestaoQuartos.TipoQuartoService;
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
public class TipoQuartoControllerTest {
    @Mock
    private TipoQuartoService tipoQuartoService;

    @InjectMocks
    private TipoQuartoController tipoQuartoController;

    @Test
    void testFindAllSuccess() {
        // Mocking
        PageRequest pageRequest = PageRequest.of(0, 10);
        Page<TipoQuartoDTO> page = new PageImpl<>(Collections.emptyList());
        when(tipoQuartoService.findAll(pageRequest)).thenReturn(page);

        // Execution
        ResponseEntity<Page<TipoQuartoDTO>> responseEntity = tipoQuartoController.findAll(0, 10);

        // Verification
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(page, responseEntity.getBody());
        verify(tipoQuartoService, times(1)).findAll(pageRequest);
    }

    @Test
    void testFindByIdSuccess() {
        // Mocking
        UUID id = UUID.randomUUID();
        Descricao descricao = Descricao.BALDE;
        TipoQuartoDTO tipoQuartoDTO = new TipoQuartoDTO( id,"Quarto Simples", 1, 1, 1, 100.00, descricao);
        when(tipoQuartoService.findById(id)).thenReturn(tipoQuartoDTO);

        // Execution
        ResponseEntity<TipoQuartoDTO> responseEntity = tipoQuartoController.findById(id);

        // Verification
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(tipoQuartoDTO, responseEntity.getBody());
        verify(tipoQuartoService, times(1)).findById(id);
    }

    @Test
    void testSaveSuccess() {
        // Mocking
        UUID id = UUID.randomUUID();
        Descricao descricao = Descricao.BALDE;
        TipoQuartoDTO tipoQuartoDTO = new TipoQuartoDTO( id,"Quarto Simples", 1, 1, 1, 100.00, descricao);
        when(tipoQuartoService.save(tipoQuartoDTO)).thenReturn(tipoQuartoDTO);

        // Execution
        ResponseEntity<TipoQuartoDTO> responseEntity = tipoQuartoController.save(tipoQuartoDTO);

        // Verification
        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals(tipoQuartoDTO, responseEntity.getBody());
        verify(tipoQuartoService, times(1)).save(tipoQuartoDTO);
    }

    @Test
    void testUpdateSuccess() {
        // Mocking
        UUID id = UUID.randomUUID();
        Descricao descricao = Descricao.BALDE;
        TipoQuartoDTO tipoQuartoDTO = new TipoQuartoDTO( id,"Quarto Simples", 1, 1, 1, 100.00, descricao);
        when(tipoQuartoService.update(id,tipoQuartoDTO)).thenReturn(tipoQuartoDTO);

        // Execution
        ResponseEntity<TipoQuartoDTO> responseEntity = tipoQuartoController.update(id, tipoQuartoDTO);

        // Verification
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(tipoQuartoDTO, responseEntity.getBody());
        verify(tipoQuartoService, times(1)).update(id, tipoQuartoDTO);
    }

    @Test
    void testDeleteSuccess() {
        // Mocking
        UUID id = UUID.randomUUID();

        // Execution
        ResponseEntity<String> responseEntity = tipoQuartoController.delete(id);

        // Verification
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals("Tipo de quarto removido com sucesso!", responseEntity.getBody());
        verify(tipoQuartoService, times(1)).delete(id);
    }
}
