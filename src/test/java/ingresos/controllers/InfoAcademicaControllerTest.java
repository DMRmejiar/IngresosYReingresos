package ingresos.controllers;

import ingresos.domain.InfoAcademica;
import ingresos.domain.InfoBachillerato;
import ingresos.service.InfoAcademicaService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class InfoAcademicaControllerTest {

    @Mock
    private InfoAcademicaService service;

    @InjectMocks
    private InfoAcademicaController controller;

    @Test
    public void testGetAll() {
        List<InfoAcademica> infoAcademicas = Arrays.asList(new InfoAcademica(), new InfoAcademica());

        when(service.getAll()).thenReturn(infoAcademicas);

        List<InfoAcademica> result = controller.getAll();

        assertEquals(infoAcademicas, result);
        verify(service).getAll();
    }

    @Test
    public void testSave() {
        InfoAcademica infoAcademica = new InfoAcademica();
        infoAcademica.setId(1L);

        when(service.save(infoAcademica)).thenReturn(infoAcademica);

        InfoAcademica result = controller.save(infoAcademica);

        assertEquals(infoAcademica, result);
        verify(service).save(infoAcademica);
    }

    @Test
    public void testGetById() {
        InfoAcademica infoAcademica = new InfoAcademica();
        infoAcademica.setId(1L);

        when(service.getById(1L)).thenReturn(Optional.of(infoAcademica));

        Optional<InfoAcademica> result = controller.getById(1L);

        assertTrue(result.isPresent());
        assertEquals(infoAcademica, result.get());
        verify(service).getById(1L);
    }

    @Test
    public void testUpdateById() {
        InfoAcademica infoAcademica = new InfoAcademica();
        infoAcademica.setId(1L);

        InfoAcademica request = new InfoAcademica();
        request.setBachillerato(new InfoBachillerato());

        when(service.updateById(request, 1L)).thenReturn(infoAcademica);

        InfoAcademica result = controller.updateUserById(request, 1L);

        assertEquals(infoAcademica, result);
        verify(service).updateById(request, 1L);
    }

    @Test
    public void testDeleteById() {
        Long id = 1L;

        when(service.delete(id)).thenReturn(true);

        String result = controller.deleteById(id);

        assertEquals("Estudiante eliminado con exito", result);
        verify(service).delete(id);
    }
}
