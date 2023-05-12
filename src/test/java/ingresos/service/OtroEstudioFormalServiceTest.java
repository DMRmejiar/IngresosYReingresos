package ingresos.service;
import ingresos.domain.MatriculaSemestre;
import ingresos.domain.OtroEstudioFormal;
import ingresos.repository.IMatriculaSemestreRepository;
import ingresos.repository.IOtroEstudioFormalRepository;
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
public class OtroEstudioFormalServiceTest {

    @Mock
    private IOtroEstudioFormalRepository repository;

    @InjectMocks
    private OtroEstudioFormalService service;

    @Test
    public void testSave() {
        OtroEstudioFormal otroEstudioFormal = new OtroEstudioFormal();
        otroEstudioFormal.setId(1L);

        when(repository.save(otroEstudioFormal)).thenReturn(otroEstudioFormal);

        OtroEstudioFormal result = service.save(otroEstudioFormal);

        assertEquals(otroEstudioFormal, result);
        verify(repository).save(otroEstudioFormal);
    }

    @Test
    public void testGetAll() {
        List<OtroEstudioFormal> otroEstudiosFormales = Arrays.asList(new OtroEstudioFormal(), new OtroEstudioFormal());

        when(repository.findAll()).thenReturn(otroEstudiosFormales);

        List<OtroEstudioFormal> result = service.getAll();

        assertEquals(otroEstudiosFormales, result);
        verify(repository).findAll();
    }

    @Test
    public void testGetById() {
        OtroEstudioFormal otroEstudioFormal = new OtroEstudioFormal();
        otroEstudioFormal.setId(1L);

        when(repository.findById(1L)).thenReturn(Optional.of(otroEstudioFormal));

        Optional<OtroEstudioFormal> result = service.getById(1L);

        assertTrue(result.isPresent());
        assertEquals(otroEstudioFormal, result.get());
        verify(repository).findById(1L);
    }

    @Test
    public void testUpdateById() {
        OtroEstudioFormal otroEstudioFormal = new OtroEstudioFormal();
        otroEstudioFormal.setId(1L);

        OtroEstudioFormal request = new OtroEstudioFormal();

        when(repository.findById(1L)).thenReturn(Optional.of(otroEstudioFormal));
        when(repository.save(otroEstudioFormal)).thenReturn(otroEstudioFormal);

        OtroEstudioFormal result = service.updateById(request, 1L);

        assertEquals(otroEstudioFormal.getId(), result.getId());
        verify(repository).findById(1L);
        verify(repository).save(otroEstudioFormal);
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