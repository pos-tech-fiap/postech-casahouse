package br.com.fiap.postechcasahouse.controller.gestaoReservas;

import br.com.fiap.postechcasahouse.DTO.gestaoReservas.EmailDTO;
import br.com.fiap.postechcasahouse.DTO.gestaoReservas.ReservaDTO;
import br.com.fiap.postechcasahouse.service.email.EmailService;
import br.com.fiap.postechcasahouse.service.gestaoReservas.ReservaService;
import jakarta.validation.Valid;
import org.hibernate.annotations.Any;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/reservas")
public class ReservaController {

    @Autowired
    private ReservaService reservaService;

    @Autowired
    private EmailService emailService;

    @GetMapping
    public ResponseEntity<Page<ReservaDTO>> findAll(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "size", defaultValue = "10") Integer size
    ) {
        PageRequest pageRequest = PageRequest.of(page, size);
        Page<ReservaDTO> reservas = reservaService.findAll(pageRequest);

        return ResponseEntity.ok(reservas);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ReservaDTO> findById(@PathVariable UUID id) {
        var reserva = reservaService.findById(id);

        return ResponseEntity.ok(reserva);
    }

    @PostMapping
    public ResponseEntity<ReservaDTO> save(@RequestBody @Valid ReservaDTO reservaDTO) {
        var reserva = reservaService.save(reservaDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(reserva);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ReservaDTO> update(@PathVariable UUID id, @RequestBody @Valid ReservaDTO reservaDTO) {
        var reserva = reservaService.update(id, reservaDTO);

        return ResponseEntity.ok(reserva);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> delete(@PathVariable UUID id) {
        reservaService.delete(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Reserva removida com sucesso!");
    }
    @PostMapping("/email")
    public ResponseEntity<String> save(@RequestBody EmailDTO emailDTO) {
        emailService.sendSimpleMessage(emailDTO.getPara(),emailDTO.getAssunto(),emailDTO.getTexto());
        return ResponseEntity.status(HttpStatus.CREATED).body("E-mail enviado com sucesso!");
    }
}
