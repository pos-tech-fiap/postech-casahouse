package br.com.fiap.postechcasahouse.controller.gestaoQuartos;

import br.com.fiap.postechcasahouse.DTO.gestaoQuartos.PredioDTO;
import br.com.fiap.postechcasahouse.service.gestaoQuartos.PredioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(value = "/predios")

public class PredioController {
    @Autowired
    private PredioService predioService;

    @GetMapping
    public ResponseEntity<Page<PredioDTO>> findAll(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "size", defaultValue = "10") Integer size
    ) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return ResponseEntity.ok().body(predioService.findAll(pageRequest));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<PredioDTO> findById(@PathVariable UUID id) {
        return ResponseEntity.ok().body(predioService.findById(id));
    }

    @PostMapping
    public ResponseEntity<PredioDTO> save(@RequestBody @Valid PredioDTO predioDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(predioService.save(predioDTO));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<PredioDTO> update(@PathVariable UUID id, @RequestBody @Valid PredioDTO predioDTO) {
        return ResponseEntity.ok().body(predioService.update(id, predioDTO));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> delete(@PathVariable UUID id) {
        predioService.delete(id);
        return ResponseEntity.ok().body("Predio removido com sucesso!");
    }

}
