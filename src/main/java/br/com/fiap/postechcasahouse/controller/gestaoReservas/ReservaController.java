package br.com.fiap.postechcasahouse.controller.gestaoReservas;

import br.com.fiap.postechcasahouse.DTO.gestaoReservas.ReservaDTO;
import br.com.fiap.postechcasahouse.service.gestaoReservas.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/reservas")
public class ReservaController {

    @Autowired
    private ReservaService reservaService;

    @GetMapping
    public ResponseEntity<Page<ReservaDTO>> findAll(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "size", defaultValue = "10") Integer size
    ) {
        PageRequest pageRequest = PageRequest.of(page, size);
        Page<ReservaDTO> reservas = reservaService.findAll(pageRequest);

        return ResponseEntity.ok(reservas);
    }
}
