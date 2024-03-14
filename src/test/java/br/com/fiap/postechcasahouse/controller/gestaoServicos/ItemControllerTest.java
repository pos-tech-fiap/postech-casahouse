package br.com.fiap.postechcasahouse.controller.gestaoServicos;

import br.com.fiap.postechcasahouse.DTO.gestaoServicos.ItemDTO;
import br.com.fiap.postechcasahouse.controller.gestaoQuartos.gestaoServicos.ItemController;
import br.com.fiap.postechcasahouse.service.gestaoServicos.ItemService;
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
public class ItemControllerTest {

    @Mock
    private ItemService itemService;

    @InjectMocks
    private ItemController itemController;

    @Test
    void testFindAllSuccess() {
        PageRequest pageRequest = PageRequest.of(0, 10);
        Page<ItemDTO> page = new PageImpl<>(Collections.emptyList());
        when(itemService.findAll(pageRequest)).thenReturn(page);

        ResponseEntity<Page<ItemDTO>> responseEntity = itemController.findAll(0, 10);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(page, responseEntity.getBody());
        verify(itemService, times(1)).findAll(pageRequest);
    }

    @Test
    void testFindByIdSuccess() {
        UUID id = UUID.randomUUID();
        ItemDTO itemDTO = new ItemDTO("Teste 01",21.12);
        when(itemService.findById(id)).thenReturn(itemDTO);

        ResponseEntity<ItemDTO> responseEntity = itemController.findById(id);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(itemDTO, responseEntity.getBody());
        verify(itemService, times(1)).findById(id);
    }

    @Test
    void testSaveSuccess() {
        ItemDTO itemDTO = new ItemDTO("Item 01",  21.12);
        when(itemService.save(itemDTO)).thenReturn(itemDTO);

        ResponseEntity<ItemDTO> responseEntity = itemController.save(itemDTO);

        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals(itemDTO, responseEntity.getBody());
        verify(itemService, times(1)).save(itemDTO);
    }

    @Test
    void testUpdateSuccess() {
        UUID id = UUID.randomUUID();
        ItemDTO itemDTO = new ItemDTO("Item 02",  1.99);
        when(itemService.update(id, itemDTO)).thenReturn(itemDTO);

        ResponseEntity<ItemDTO> responseEntity = itemController.update(id, itemDTO);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(itemDTO, responseEntity.getBody());
        verify(itemService, times(1)).update(id, itemDTO);
    }

    @Test
    void testDeleteSuccess() {
        UUID id = UUID.randomUUID();

        ResponseEntity<String> responseEntity = itemController.delete(id);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals("Item removido com sucesso!", responseEntity.getBody());
        verify(itemService, times(1)).delete(id);
    }
}
