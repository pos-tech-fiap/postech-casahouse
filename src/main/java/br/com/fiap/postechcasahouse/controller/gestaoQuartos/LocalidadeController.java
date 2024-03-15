package br.com.fiap.postechcasahouse.controller.gestaoQuartos;

import br.com.fiap.postechcasahouse.DTO.gestaoQuartos.LocalidadeDTO;
import br.com.fiap.postechcasahouse.service.gestaoQuartos.LocalidadeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(value = "/localidade")

public class LocalidadeController {
    @Autowired
    private LocalidadeService localidadeService;

    @GetMapping
    public ResponseEntity<Page<LocalidadeDTO>> findAll(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "size", defaultValue = "10") Integer size
    ) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return ResponseEntity.ok().body(localidadeService.findAll(pageRequest));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<LocalidadeDTO> findById(@PathVariable UUID id) {
        return ResponseEntity.ok().body(localidadeService.findById(id));
    }

    @PostMapping
    public ResponseEntity<LocalidadeDTO> save(@RequestBody @Valid LocalidadeDTO localidadeDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(localidadeService.save(localidadeDTO));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<LocalidadeDTO> update(@PathVariable UUID id, @RequestBody @Valid LocalidadeDTO localidadeDTO) {
        return ResponseEntity.ok().body(localidadeService.update(id, localidadeDTO));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> delete(@PathVariable UUID id) {
        localidadeService.delete(id);
        return ResponseEntity.ok().body("Localidade removida com sucesso!");
    }

}
