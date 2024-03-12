package br.com.fiap.postechcasahouse.controller.gestaoQuartos.gestaoServicos;

import br.com.fiap.postechcasahouse.DTO.gestaoServicos.ServicoDTO;
import br.com.fiap.postechcasahouse.service.gestaoServicos.ServicoService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/servicos")
public class ServicoController {

    @Autowired
    private ServicoService servicoService;

    @GetMapping
    public ResponseEntity<Page<ServicoDTO>> findAll(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "size", defaultValue = "10") Integer size
    ) {
        PageRequest pageRequest = PageRequest.of(page, size);
        Page<ServicoDTO> addresses = servicoService.findAll(pageRequest);
        return ResponseEntity.ok().body(addresses);
    }

    @PostMapping
    public ResponseEntity<ServicoDTO> save(@RequestBody @Valid ServicoDTO servicoDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(servicoService.save(servicoDTO));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ServicoDTO> update(@PathVariable UUID id, @RequestBody @Valid ServicoDTO servicoDTO) {
        return ResponseEntity.ok().body(servicoService.update(id, servicoDTO));
    }
}
