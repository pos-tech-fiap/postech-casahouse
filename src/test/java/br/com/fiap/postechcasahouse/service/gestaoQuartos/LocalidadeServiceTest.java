//package br.com.fiap.postechcasahouse.service.gestaoQuartos;
//
//
//import br.com.fiap.postechcasahouse.DTO.gestaoQuartos.LocalidadeDTO;
//import br.com.fiap.postechcasahouse.entity.gestaoQuartos.Amenidades;
//import br.com.fiap.postechcasahouse.entity.gestaoQuartos.Localidade;
//import br.com.fiap.postechcasahouse.repository.gestaoQuartos.ILocalidadeRepository;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageImpl;
//import org.springframework.data.domain.PageRequest;
//
//import java.util.Collections;
//import java.util.Optional;
//import java.util.UUID;
//
//import static org.hamcrest.core.IsInstanceOf.any;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.*;
//
//public class LocalidadeServiceTest {
//
//    @Mock
//    private ILocalidadeRepository localidadeRepository;
//
//    @InjectMocks
//    private LocalidadeService localidadeService;
//
//    @BeforeEach
//    void setUp() {
//        MockitoAnnotations.initMocks(this);
//    }
//
//    @Test
//    void testFindAll() {
//        // Given
//        PageRequest pageRequest = PageRequest.of(0, 10);
//        Localidade localidade = new Localidade();
//        Page<Localidade> localidadesPage = new PageImpl<>(Collections.singletonList(localidade));
//
//        when(localidadeRepository.findAll(pageRequest)).thenReturn(localidadesPage);
//
//        // When
//        Page<LocalidadeDTO> result = localidadeService.findAll(pageRequest);
//
//        // Then
//        assertEquals(1, result.getTotalElements());
//    }
//
//    @Test
//    void testFindById() {
//        // Given
//        UUID id = UUID.randomUUID();
//        Localidade localidade = new Localidade();
//
//        when(localidadeRepository.findById(id)).thenReturn(Optional.of(localidade));
//
//        // When
//        LocalidadeDTO result = localidadeService.findById(id);
//
//        // Then
//        assertEquals(id, result.getId());
//    }
//
//    @Test
//    void testSave() {
//        // Given
//        UUID id = UUID.randomUUID();
//        Amenidades amenidades = Amenidades.AREA_KIDS_BIBLIOTECA;
//        LocalidadeDTO localidadeDTO = new LocalidadeDTO( id, "Localidade 1",  amenidades,"Rua A","12345-678","Cidade A", "Estado A");
//        Localidade localidade = new Localidade();
//
//        when(localidadeRepository.save(localidadeDTO)).thenReturn(localidadeDTO);
//
//        // When
//        LocalidadeDTO result = localidadeService.save(localidadeDTO);
//
//        // Then
//        assertEquals(localidade.getId(), result.getId());
//    }
//
//    @Test
//    void testUpdate() {
//        // Given
//        UUID id = UUID.randomUUID();
//        LocalidadeDTO localidadeDTO = new LocalidadeDTO();
//        Localidade localidade = new Localidade();
//        localidade.setId(id);
//
//        when(localidadeRepository.getOne(id)).thenReturn(localidade);
//        when(localidadeRepository.save(any(Localidade.class))).thenReturn(localidade);
//
//        // When
//        LocalidadeDTO result = localidadeService.update(id, localidadeDTO);
//
//        // Then
//        assertEquals(id, result.getId());
//    }
//
//    @Test
//    void testDelete() {
//        // Given
//        UUID id = UUID.randomUUID();
//
//        // When
//        localidadeService.delete(id);
//
//        // Then
//        verify(localidadeRepository, times(1)).deleteById(id);
//    }
//}
