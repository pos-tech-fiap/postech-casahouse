package br.com.fiap.postechcasahouse.controller.gestaoQuartos;

import br.com.fiap.postechcasahouse.DTO.gestaoQuartos.LocalidadeDTO;
import br.com.fiap.postechcasahouse.entity.gestaoQuartos.Amenidades;
import br.com.fiap.postechcasahouse.service.gestaoQuartos.LocalidadeService;
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
import org.springframework.web.server.ResponseStatusException;

import java.util.Collections;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class LocalidadeControllerTest {
    @Mock
    private LocalidadeService localidadeService;

    @InjectMocks
    private LocalidadeController localidadeController;

    @Test
    void testFindAllSuccess() {
        // Mocking
        PageRequest pageRequest = PageRequest.of(0, 10);
        Page<LocalidadeDTO> page = new PageImpl<>(Collections.emptyList());
        when(localidadeService.findAll(pageRequest)).thenReturn(page);

        // Execution
        ResponseEntity<Page<LocalidadeDTO>> responseEntity = localidadeController.findAll(0, 10);

        // Verification
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(page, responseEntity.getBody());
        verify(localidadeService, times(1)).findAll(pageRequest);
    }

    @Test
    void testFindByIdSuccess() {
        // Mocking
        UUID id = UUID.randomUUID();
        Amenidades amenidades = Amenidades.AREA_KIDS_BIBLIOTECA;
        LocalidadeDTO localidadeDTO = new LocalidadeDTO( id, "Localidade 1",  amenidades,"Rua A","12345-678","Cidade A", "Estado A");
        when(localidadeService.findById(id)).thenReturn(localidadeDTO);

        // Execution
        ResponseEntity<LocalidadeDTO> responseEntity = localidadeController.findById(id);

        // Verification
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(localidadeDTO, responseEntity.getBody());
        verify(localidadeService, times(1)).findById(id);
    }

    @Test
    void testSaveSuccess() {
        // Mocking
        UUID id = UUID.randomUUID();
        Amenidades amenidades = Amenidades.AREA_KIDS_BIBLIOTECA;
        LocalidadeDTO localidadeDTO = new LocalidadeDTO( id, "Localidade 1",  amenidades,"Rua A","12345-678","Cidade A", "Estado A");
        when(localidadeService.save(localidadeDTO)).thenReturn(localidadeDTO);

        // Execution
        ResponseEntity<LocalidadeDTO> responseEntity = localidadeController.save(localidadeDTO);

        // Verification
        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals(localidadeDTO, responseEntity.getBody());
        verify(localidadeService, times(1)).save(localidadeDTO);
    }

    @Test
    void testUpdateSuccess() {
        // Mocking
        UUID id = UUID.randomUUID();
        Amenidades amenidades = Amenidades.AREA_KIDS_BIBLIOTECA;
        LocalidadeDTO localidadeDTO = new LocalidadeDTO( id, "Localidade 1",  amenidades,"Rua A","12345-678","Cidade A", "Estado A");
        when(localidadeService.update(id, localidadeDTO)).thenReturn(localidadeDTO);

        // Execution
        ResponseEntity<LocalidadeDTO> responseEntity = localidadeController.update(id, localidadeDTO);

        // Verification
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(localidadeDTO, responseEntity.getBody());
        verify(localidadeService, times(1)).update(id, localidadeDTO);
    }

    @Test
    void testDeleteSuccess() {
        // Mocking
        UUID id = UUID.randomUUID();

        // Execution
        ResponseEntity<String> responseEntity = localidadeController.delete(id);

        // Verification
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals("Localidade removida com sucesso!", responseEntity.getBody());
        verify(localidadeService, times(1)).delete(id);
    }
}
