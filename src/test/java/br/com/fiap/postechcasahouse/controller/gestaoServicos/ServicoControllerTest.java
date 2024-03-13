package br.com.fiap.postechcasahouse.controller.gestaoServicos;

import br.com.fiap.postechcasahouse.DTO.gestaoServicos.ServicoDTO;
import br.com.fiap.postechcasahouse.service.gestaoServicos.ServicoService;
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
public class ServicoControllerTest {

    @Mock
    private ServicoService servicoService;

    @InjectMocks
    private ServicoController servicoController;

    @Test
    void testFindAllSuccess() {
        PageRequest pageRequest = PageRequest.of(0, 10);
        Page<ServicoDTO> page = new PageImpl<>(Collections.emptyList());
        when(servicoService.findAll(pageRequest)).thenReturn(page);

        ResponseEntity<Page<ServicoDTO>> responseEntity = servicoController.findAll(0, 10);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(page, responseEntity.getBody());
        verify(servicoService, times(1)).findAll(pageRequest);
    }

    @Test
    void testFindByIdSuccess() {
        UUID id = UUID.randomUUID();
        ServicoDTO servicoDTO = new ServicoDTO("Teste 01",21.12);
        when(servicoService.findById(id)).thenReturn(servicoDTO);

        ResponseEntity<ServicoDTO> responseEntity = servicoController.findById(id);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(servicoDTO, responseEntity.getBody());
        verify(servicoService, times(1)).findById(id);
    }

    @Test
    void testSaveSuccess() {
        ServicoDTO servicoDTO = new ServicoDTO("Serviço 01",  24.49);
        when(servicoService.save(servicoDTO)).thenReturn(servicoDTO);

        ResponseEntity<ServicoDTO> responseEntity = servicoController.save(servicoDTO);

        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals(servicoDTO, responseEntity.getBody());
        verify(servicoService, times(1)).save(servicoDTO);
    }

    @Test
    void testUpdateSuccess() {
        UUID id = UUID.randomUUID();
        ServicoDTO servicoDTO = new ServicoDTO("Serviço 02",  49.99);
        when(servicoService.update(id, servicoDTO)).thenReturn(servicoDTO);

        ResponseEntity<ServicoDTO> responseEntity = servicoController.update(id, servicoDTO);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(servicoDTO, responseEntity.getBody());
        verify(servicoService, times(1)).update(id, servicoDTO);
    }

    @Test
    void testDeleteSuccess() {
        UUID id = UUID.randomUUID();

        ResponseEntity<String> responseEntity = servicoController.delete(id);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals("Serviço removido com sucesso!", responseEntity.getBody());
        verify(servicoService, times(1)).delete(id);
    }
}
