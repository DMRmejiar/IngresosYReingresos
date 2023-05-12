package ingresos.service;

import ingresos.domain.InfoPersonal;
import ingresos.repository.IInfoPersonalRepository;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;
@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class InfoPersonalServiceTest {

    @Mock
    private IInfoPersonalRepository repository;

    @InjectMocks
    private InfoPersonalService service;

    @Test
    public void testSave() {
        InfoPersonal infoPersonal = new InfoPersonal();
        infoPersonal.setId(1L);
        infoPersonal.setNombre("John");

        when(repository.save(infoPersonal)).thenReturn(infoPersonal);

        InfoPersonal result = service.save(infoPersonal);

        assertEquals(infoPersonal, result);
        verify(repository).save(infoPersonal);
    }

    @Test
    public void testGetAll() {
        List<InfoPersonal> infoPersonals = Arrays.asList(new InfoPersonal(), new InfoPersonal());

        when(repository.findAll()).thenReturn(infoPersonals);

        List<InfoPersonal> result = service.getAll();

        assertEquals(infoPersonals, result);
        verify(repository).findAll();
    }

    @Test
    public void testGetById() {
        InfoPersonal infoPersonal = new InfoPersonal();
        infoPersonal.setId(1L);
        infoPersonal.setNombre("John");

        when(repository.findById(1L)).thenReturn(Optional.of(infoPersonal));

        Optional<InfoPersonal> result = service.getById(1L);

        assertTrue(result.isPresent());
        assertEquals(infoPersonal, result.get());
        verify(repository).findById(1L);
    }

    @Test
    public void testUpdateById() {
        InfoPersonal infoPersonal = new InfoPersonal();
        infoPersonal.setId(1L);
        infoPersonal.setNombre("John");

        InfoPersonal request = new InfoPersonal();
        request.setNombre("Jane");

        when(repository.findById(1L)).thenReturn(Optional.of(infoPersonal));
        when(repository.save(infoPersonal)).thenReturn(infoPersonal);

        InfoPersonal result = service.updateById(request, 1L);

        assertEquals("Jane", result.getNombre());
        verify(repository).findById(1L);
        verify(repository).save(infoPersonal);
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
