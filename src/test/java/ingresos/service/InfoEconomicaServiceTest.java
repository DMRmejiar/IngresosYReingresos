package ingresos.service;

import ingresos.domain.InfoEconomica;
import ingresos.repository.IInfoEconomicaRepository;
import org.springframework.boot.test.context.SpringBootTest;
import ingresos.domain.InfoBachillerato;
import ingresos.repository.IInfoBachilleratoRepository;
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
public class InfoEconomicaServiceTest {

    @Mock
    private IInfoEconomicaRepository repository;

    @InjectMocks
    private InfoEconomicaService service;

    @Test
    public void testSave() {
        InfoEconomica infoEconomica = new InfoEconomica();
        infoEconomica.setId(1L);

        when(repository.save(infoEconomica)).thenReturn(infoEconomica);

        InfoEconomica result = service.save(infoEconomica);

        assertEquals(infoEconomica, result);
        verify(repository).save(infoEconomica);
    }

    @Test
    public void testGetAll() {
        List<InfoEconomica> infoEconomicas = Arrays.asList(new InfoEconomica(), new InfoEconomica());

        when(repository.findAll()).thenReturn(infoEconomicas);

        List<InfoEconomica> result = service.getAll();

        assertEquals(infoEconomicas, result);
        verify(repository).findAll();
    }

    @Test
    public void testGetById() {
        InfoEconomica infoEconomica = new InfoEconomica();
        infoEconomica.setId(1L);

        when(repository.findById(1L)).thenReturn(Optional.of(infoEconomica));

        Optional<InfoEconomica> result = service.getById(1L);

        assertTrue(result.isPresent());
        assertEquals(infoEconomica, result.get());
        verify(repository).findById(1L);
    }

    @Test
    public void testUpdateById() {
        InfoEconomica infoEconomica = new InfoEconomica();
        infoEconomica.setId(1L);

        InfoEconomica request = new InfoEconomica();

        when(repository.findById(1L)).thenReturn(Optional.of(infoEconomica));
        when(repository.save(infoEconomica)).thenReturn(infoEconomica);

        InfoEconomica result = service.updateById(request, 1L);

        assertEquals(infoEconomica.getId(), result.getId());
        verify(repository).findById(1L);
        verify(repository).save(infoEconomica);
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
