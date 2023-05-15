package ingresos.service;

import ingresos.domain.InfoBachillerato;
import ingresos.repository.IInfoBachilleratoRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
@ExtendWith(MockitoExtension.class)
public class InfoBachilleratoServiceTest {

    @Mock
    private IInfoBachilleratoRepository repository;

    @InjectMocks
    private InfoBachilleratoService service;

    @Test
    public void testSave() {
        InfoBachillerato infoBachillerato = new InfoBachillerato();
        infoBachillerato.setId(1L);

        when(repository.save(infoBachillerato)).thenReturn(infoBachillerato);

        InfoBachillerato result = service.save(infoBachillerato);

        assertEquals(infoBachillerato, result);
        verify(repository).save(infoBachillerato);
    }

    @Test
    public void testGetAll() {
        List<InfoBachillerato> infoBachilleratos = Arrays.asList(new InfoBachillerato(), new InfoBachillerato());

        when(repository.findAll()).thenReturn(infoBachilleratos);

        List<InfoBachillerato> result = service.getAll();

        assertEquals(infoBachilleratos, result);
        verify(repository).findAll();
    }

    @Test
    public void testGetById() {
        InfoBachillerato infoBachillerato = new InfoBachillerato();
        infoBachillerato.setId(1L);


        when(repository.findById(1L)).thenReturn(Optional.of(infoBachillerato));

        Optional<InfoBachillerato> result = service.getById(1L);

        assertTrue(result.isPresent());
        assertEquals(infoBachillerato, result.get());
        verify(repository).findById(1L);
    }

    @Test
    public void testUpdateById() {
        InfoBachillerato infoBachillerato = new InfoBachillerato();
        infoBachillerato.setId(1L);

        InfoBachillerato request = new InfoBachillerato();

        when(repository.findById(1L)).thenReturn(Optional.of(infoBachillerato));
        when(repository.save(infoBachillerato)).thenReturn(infoBachillerato);

        InfoBachillerato result = service.updateById(request, 1L);

        assertEquals(infoBachillerato.getId(), result.getId());
        verify(repository).findById(1L);
        verify(repository).save(infoBachillerato);
    }

    @Test
    public void testDelete() {
        Long id = 1L;

        doNothing().when(repository).deleteById(id);

        Boolean result = service.delete(id);

        assertTrue(result);
        verify(repository).deleteById(id);
    }
}
