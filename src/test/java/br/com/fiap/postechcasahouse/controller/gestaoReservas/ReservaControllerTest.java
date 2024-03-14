package br.com.fiap.postechcasahouse.controller.gestaoReservas;

import br.com.fiap.postechcasahouse.DTO.gestaoReservas.ReservaDTO;
import br.com.fiap.postechcasahouse.service.gestaoReservas.ReservaService;
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
public class ReservaControllerTest {

    @Mock
    private ReservaService reservaService;

    @InjectMocks
    private ReservaController reservaController;

    @Test
    void testFindAllSuccess() {
        PageRequest pageRequest = PageRequest.of(0, 10);
        Page<ReservaDTO> page = new PageImpl<>(Collections.emptyList());
        when(reservaService.findAll(pageRequest)).thenReturn(page);

        ResponseEntity<Page<ReservaDTO>> responseEntity = reservaController.findAll(0,10);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(page, responseEntity.getBody());
        verify(reservaService, times(1)).findAll(pageRequest);
    }

    @Test
    void testFindByIdSuccess() {
        UUID id = UUID.randomUUID();
        UUID clienteId = UUID.randomUUID();
        LocalDateTime dataEntrada = LocalDateTime.parse("2025-05-10T12:00:00");
        LocalDateTime dataSaida = LocalDateTime.parse("2025-05-15T12:00:00");
        ReservaDTO reservaDTO = new ReservaDTO(clienteId, dataEntrada, dataSaida, 5, 1500.30);
        when(reservaService.findById(id)).thenReturn(reservaDTO);

        ResponseEntity<ReservaDTO> responseEntity = reservaController.findById(id);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(reservaDTO, responseEntity.getBody());
        verify(reservaService, times(1)).findById(id);
    }

    @Test
    void testSaveSuccess() {
        UUID clienteId = UUID.randomUUID();
        LocalDateTime dataEntrada = LocalDateTime.parse("2025-05-10T12:00:00");
        LocalDateTime dataSaida = LocalDateTime.parse("2025-05-15T12:00:00");
        ReservaDTO reservaDTO = new ReservaDTO(clienteId, dataEntrada, dataSaida, 5, 1500.30);
        when(reservaService.save(reservaDTO)).thenReturn(reservaDTO);

        ResponseEntity<ReservaDTO> responseEntity = reservaController.save(reservaDTO);

        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals(reservaDTO, responseEntity.getBody());
        verify(reservaService, times(1)).save(reservaDTO);
    }

    @Test
    void testUpdateSuccess() {
        UUID id = UUID.randomUUID();
        UUID clienteId = UUID.randomUUID();
        LocalDateTime dataEntrada = LocalDateTime.parse("2025-05-10T12:00:00");
        LocalDateTime dataSaida = LocalDateTime.parse("2025-05-15T12:00:00");
        ReservaDTO reservaDTO = new ReservaDTO(clienteId, dataEntrada, dataSaida, 5, 1500.30);
        when(reservaService.update(id, reservaDTO)).thenReturn(reservaDTO);

        ResponseEntity<ReservaDTO> responseEntity = reservaController.update(id, reservaDTO);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(reservaDTO, responseEntity.getBody());
        verify(reservaService, times(1)).update(id, reservaDTO);
    }

    @Test
    void testDeleteSuccess() {
        UUID id = UUID.randomUUID();

        ResponseEntity<String> responseEntity = reservaController.delete(id);

        assertEquals(HttpStatus.NO_CONTENT, responseEntity.getStatusCode());
        assertEquals("Reserva removida com sucesso!", responseEntity.getBody());
        verify(reservaService, times(1)).delete(id);
    }
}
