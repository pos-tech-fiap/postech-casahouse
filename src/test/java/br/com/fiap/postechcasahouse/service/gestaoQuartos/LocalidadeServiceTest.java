package br.com.fiap.postechcasahouse.service.gestaoQuartos;


import br.com.fiap.postechcasahouse.repository.gestaoQuartos.ILocalidadeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class LocalidadeServiceTest {
    @Mock
    private ILocalidadeRepository localidadeRepository;

    @InjectMocks
    private LocalidadeService localidadeService;

    @BeforeEach
    void setUp() {
        // Configurações de inicialização, se necessário
    }

//    @Test
//    void testFindAll() {
//        // Mocking
//        PageRequest pageRequest = PageRequest.of(0, 10);
//        List<Localidade> localidadeList = criarLocalidades(10);
//        Page<Localidade> page = new PageImpl<>(localidadeList);
//        when(localidadeRepository.findAll(pageRequest)).thenReturn(page);
//
//        // Execution
//        Page<LocalidadeDTO> result = localidadeService.findAll(pageRequest);
//
//        // Verification
//        assertEquals(localidadeList.size(), result.getTotalElements());
//        assertEquals(localidadeList.size(), result.getContent().size());
//        assertEquals(localidadeList.get(0).getNome(), result.getContent().get(0).getNome());
//        verify(localidadeRepository, times(1)).findAll(pageRequest);
//    }
//
//    @Test
//    void testFindById() {
//        // Mocking
//        UUID id = UUID.randomUUID();
//        Localidade localidade = new Localidade();
//        when(localidadeRepository.findById(id)).thenReturn(Optional.of(localidade));
//
//        // Execution
//        LocalidadeDTO result = localidadeService.findById(id);
//
//        // Verification
//        assertNotNull(result);
//        assertEquals(localidade.getId(), result.getId());
//        // Adicione mais verificações conforme necessário
//    }

}
