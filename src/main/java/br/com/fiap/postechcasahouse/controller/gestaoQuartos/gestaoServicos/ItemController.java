package br.com.fiap.postechcasahouse.controller.gestaoQuartos.gestaoServicos;

import br.com.fiap.postechcasahouse.DTO.gestaoServicos.ItemDTO;
import br.com.fiap.postechcasahouse.service.gestaoServicos.ItemService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/itens")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping
    public ResponseEntity<Page<ItemDTO>> findAll(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "size", defaultValue = "10") Integer size
    ) {
        PageRequest pageRequest = PageRequest.of(page, size);
        Page<ItemDTO> itemDTOPage = itemService.findAll(pageRequest);
        return ResponseEntity.ok().body(itemDTOPage);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ItemDTO> findById(@PathVariable UUID id) {
        return ResponseEntity.ok().body(itemService.findById(id));
    }

    @PostMapping
    public ResponseEntity<ItemDTO> save(@RequestBody @Valid ItemDTO itemDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(itemService.save(itemDTO));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ItemDTO> update(@PathVariable UUID id, @RequestBody @Valid ItemDTO itemDTO) {
        return ResponseEntity.ok().body(itemService.update(id, itemDTO));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> delete(@PathVariable UUID id) {
        itemService.delete(id);
        return ResponseEntity.ok().body("Item removido com sucesso!");
    }
}
