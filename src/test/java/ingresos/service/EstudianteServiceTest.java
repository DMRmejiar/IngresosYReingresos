package ingresos.service;

import ingresos.domain.Estudiante;
import ingresos.repository.IEstudianteRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class EstudianteServiceTest {

    @Mock
    private IEstudianteRepository repository;

    @InjectMocks
    private EstudianteService service;

    @Test
    public void testSave() {
        Estudiante estudiante = new Estudiante();
        estudiante.setId(1L);

        when(repository.save(estudiante)).thenReturn(estudiante);

        Estudiante result = service.save(estudiante);

        assertEquals(estudiante, result);
        verify(repository).save(estudiante);
    }

    @Test
    public void testGetAll() {
        List<Estudiante> estudiantes = Arrays.asList(new Estudiante(), new Estudiante());

        when(repository.findAll()).thenReturn(estudiantes);

        List<Estudiante> result = service.getAll();

        assertEquals(estudiantes, result);
        verify(repository).findAll();
    }

    @Test
    public void testGetById() {
        Estudiante estudiante = new Estudiante();
        estudiante.setId(1L);

        when(repository.findById(1L)).thenReturn(Optional.of(estudiante));

        Optional<Estudiante> result = service.getById(1L);

        assertTrue(result.isPresent());
        assertEquals(estudiante, result.get());
        verify(repository).findById(1L);
    }

    @Test
    public void testUpdateById() {
        Estudiante estudiante = new Estudiante();
        estudiante.setId(1L);

        Estudiante request = new Estudiante();
        when(repository.findById(1L)).thenReturn(Optional.of(estudiante));
        when(repository.save(estudiante)).thenReturn(estudiante);

        Estudiante result = service.updateById(request, 1L);

        verify(repository).findById(1L);
        verify(repository).save(estudiante);
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
