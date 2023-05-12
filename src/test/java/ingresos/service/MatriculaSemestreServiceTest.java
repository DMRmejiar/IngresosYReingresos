package ingresos.service;

import ingresos.domain.MatriculaSemestre;
import ingresos.repository.IMatriculaSemestreRepository;
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
public class MatriculaSemestreServiceTest {

    @Mock
    private IMatriculaSemestreRepository repository;

    @InjectMocks
    private MatriculaSemestreService service;

    @Test
    public void testSave() {
        MatriculaSemestre matriculaSemestre = new MatriculaSemestre();
        matriculaSemestre.setId(1L);

        when(repository.save(matriculaSemestre)).thenReturn(matriculaSemestre);

        MatriculaSemestre result = service.save(matriculaSemestre);

        assertEquals(matriculaSemestre, result);
        verify(repository).save(matriculaSemestre);
    }

    @Test
    public void testGetAll() {
        List<MatriculaSemestre> matriculaSemestres = Arrays.asList(new MatriculaSemestre(), new MatriculaSemestre());

        when(repository.findAll()).thenReturn(matriculaSemestres);

        List<MatriculaSemestre> result = service.getAll();

        assertEquals(matriculaSemestres, result);
        verify(repository).findAll();
    }

    @Test
    public void testGetById() {
        MatriculaSemestre matriculaSemestre = new MatriculaSemestre();
        matriculaSemestre.setId(1L);

        when(repository.findById(1L)).thenReturn(Optional.of(matriculaSemestre));

        Optional<MatriculaSemestre> result = service.getById(1L);

        assertTrue(result.isPresent());
        assertEquals(matriculaSemestre, result.get());
        verify(repository).findById(1L);
    }

    @Test
    public void testUpdateById() {
        MatriculaSemestre matriculaSemestre = new MatriculaSemestre();
        matriculaSemestre.setId(1L);

        MatriculaSemestre request = new MatriculaSemestre();

        when(repository.findById(1L)).thenReturn(Optional.of(matriculaSemestre));
        when(repository.save(matriculaSemestre)).thenReturn(matriculaSemestre);

        MatriculaSemestre result = service.updateById(request, 1L);

        assertEquals(matriculaSemestre.getId(), result.getId());
        verify(repository).findById(1L);
        verify(repository).save(matriculaSemestre);
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
