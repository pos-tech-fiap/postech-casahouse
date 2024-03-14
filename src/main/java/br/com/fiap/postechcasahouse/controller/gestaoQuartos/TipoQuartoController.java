package br.com.fiap.postechcasahouse.controller.gestaoQuartos;

import br.com.fiap.postechcasahouse.DTO.gestaoQuartos.TipoQuartoDTO;
import br.com.fiap.postechcasahouse.service.gestaoQuartos.TipoQuartoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(value = "/tipo-quarto")

public class TipoQuartoController {
    @Autowired
    private TipoQuartoService tipoQuartoService;

    @GetMapping
    public ResponseEntity<Page<TipoQuartoDTO>> findAll(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "size", defaultValue = "10") Integer size
    ) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return ResponseEntity.ok().body(tipoQuartoService.findAll(pageRequest));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<TipoQuartoDTO> findById(@PathVariable UUID id) {
        return ResponseEntity.ok().body(tipoQuartoService.findById(id));
    }

    @PostMapping
    public ResponseEntity<TipoQuartoDTO> save(@RequestBody @Valid TipoQuartoDTO tipoQuartoDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(tipoQuartoService.save(tipoQuartoDTO));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<TipoQuartoDTO> update(@PathVariable UUID id, @RequestBody @Valid TipoQuartoDTO tipoQuartoDTO) {
        return ResponseEntity.ok().body(tipoQuartoService.update(id, tipoQuartoDTO));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> delete(@PathVariable UUID id) {
        tipoQuartoService.delete(id);
        return ResponseEntity.ok().body("Tipo de quarto removido com sucesso!");
    }

}
