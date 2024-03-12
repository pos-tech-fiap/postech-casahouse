package br.com.fiap.postechcasahouse.controllers.servicos;

import br.com.fiap.postechcasahouse.dtos.servicos.ServicoDTO;
import br.com.fiap.postechcasahouse.services.servicos.ServicoService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/servicos")
public class ServicoController {

    @Autowired
    private ServicoService servicoService;

    @PostMapping
    public ResponseEntity<ServicoDTO> save(@RequestBody @Valid ServicoDTO servicoDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(servicoService.save(servicoDTO));
    }

}
