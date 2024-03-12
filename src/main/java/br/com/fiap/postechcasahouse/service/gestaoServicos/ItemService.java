package br.com.fiap.postechcasahouse.service.gestaoServicos;

import br.com.fiap.postechcasahouse.DTO.gestaoServicos.ItemDTO;
import br.com.fiap.postechcasahouse.entity.gestaoServicos.Item;
import br.com.fiap.postechcasahouse.repository.gestaoServicos.ItemRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.UUID;

@Service
@Transactional
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public Page<ItemDTO> findAll(PageRequest pageRequest) {
        Page<Item> itemPage = itemRepository.findAll(pageRequest);
        return itemPage.map(ItemDTO::new);
    }

    public ItemDTO save(ItemDTO itemDTO) {
        Item item = new Item();
        mapperDtoToEntity(itemDTO, item);
        itemRepository.save(item);

        return new ItemDTO(item);
    }

    public ItemDTO update(UUID id, ItemDTO itemDTO) {
        try {
            Item item = itemRepository.getOne(id);
            mapperDtoToEntity(itemDTO, item);
            return new ItemDTO(itemRepository.save(item));
        } catch (NoSuchElementException e) {
            throw new RuntimeException("Item não encontrado, id: " + id);
        }
    }

    public void delete(UUID id) {
        try {
            itemRepository.deleteById(id);
        } catch (NoSuchElementException e) {
            throw new RuntimeException("Item não encontrado, id: " + id);
        }
    }

    private void mapperDtoToEntity(ItemDTO dto, Item item) {
        item.setNome(dto.getNome());
        item.setValor(dto.getValor());
    }
}
