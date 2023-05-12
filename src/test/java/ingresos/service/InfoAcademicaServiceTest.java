package ingresos.service;

import ingresos.domain.InfoAcademica;
import ingresos.domain.InfoBachillerato;
import ingresos.repository.IInfoAcademicaRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class InfoAcademicaServiceTest {

    @Mock
    private IInfoAcademicaRepository repository;

    @InjectMocks
    private InfoAcademicaService service;

    @Test
    public void testSave() {
        InfoAcademica infoAcademica = new InfoAcademica();
        infoAcademica.setId(1L);

        when(repository.save(infoAcademica)).thenReturn(infoAcademica);

        InfoAcademica result = service.save(infoAcademica);

        assertEquals(infoAcademica, result);
        verify(repository).save(infoAcademica);
    }

    @Test
    public void testGetAll() {
        List<InfoAcademica> infoAcademicas = Arrays.asList(new InfoAcademica(), new InfoAcademica());

        when(repository.findAll()).thenReturn(infoAcademicas);

        List<InfoAcademica> result = service.getAll();

        assertEquals(infoAcademicas, result);
        verify(repository).findAll();
    }

    @Test
    public void testGetById() {
        InfoAcademica infoAcademica = new InfoAcademica();
        infoAcademica.setId(1L);

        when(repository.findById(1L)).thenReturn(Optional.of(infoAcademica));

        Optional<InfoAcademica> result = service.getById(1L);

        assertTrue(result.isPresent());
        assertEquals(infoAcademica, result.get());
        verify(repository).findById(1L);
    }

    @Test
    public void testUpdateById() {
        InfoAcademica infoAcademica = new InfoAcademica();
        infoAcademica.setId(1L);

        InfoAcademica request = new InfoAcademica();

        when(repository.findById(1L)).thenReturn(Optional.of(infoAcademica));
        when(repository.save(infoAcademica)).thenReturn(infoAcademica);

        InfoAcademica result = service.updateById(request, 1L);

        assertEquals(infoAcademica.getId(), result.getId());
        verify(repository).findById(1L);
        verify(repository).save(infoAcademica);
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
