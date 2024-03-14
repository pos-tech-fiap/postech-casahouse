package br.com.fiap.postechcasahouse.controller.gestaoQuartos;

import br.com.fiap.postechcasahouse.DTO.gestaoQuartos.QuartoDTO;
import br.com.fiap.postechcasahouse.service.gestaoQuartos.QuartoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(value = "/quartos")

public class QuartoController {
    @Autowired
    private QuartoService quartoService;

    @GetMapping
    public ResponseEntity<Page<QuartoDTO>> findAll(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "size", defaultValue = "10") Integer size
    ) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return ResponseEntity.ok().body(quartoService.findAll(pageRequest));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<QuartoDTO> findById(@PathVariable UUID id) {
        return ResponseEntity.ok().body(quartoService.findById(id));
    }

    @PostMapping
    public ResponseEntity<QuartoDTO> save(@RequestBody @Valid QuartoDTO quartoDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(quartoService.save(quartoDTO));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<QuartoDTO> update(@PathVariable UUID id, @RequestBody @Valid QuartoDTO quartoDTO) {
        return ResponseEntity.ok().body(quartoService.update(id, quartoDTO));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> delete(@PathVariable UUID id) {
        quartoService.delete(id);
        return ResponseEntity.ok().body("Quarto removido com sucesso!");
    }

}
