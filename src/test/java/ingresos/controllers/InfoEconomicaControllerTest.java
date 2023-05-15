package ingresos.controllers;

import ingresos.domain.InfoEconomica;
import ingresos.service.InfoEconomicaService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
@RunWith(MockitoJUnitRunner.class)
public class InfoEconomicaControllerTest {

    @Mock
    private InfoEconomicaService service;

    @InjectMocks
    private InfoEconomicaController controller;

    @Test
    public void testGetAll() {
        // Arrange
        List<InfoEconomica> expected = new ArrayList<>();
        expected.add(new InfoEconomica());
        when(service.getAll()).thenReturn(expected);

        // Act
        List<InfoEconomica> actual = controller.getAll();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void testSave() {
        // Arrange
        InfoEconomica toSave = new InfoEconomica();
        when(service.save(toSave)).thenReturn(toSave);

        // Act
        InfoEconomica actual = controller.save(toSave);

        // Assert
        assertEquals(toSave, actual);
    }

    @Test
    public void testGetById() {
        // Arrange
        Long id = 1L;
        Optional<InfoEconomica> expected = Optional.of(new InfoEconomica());
        when(service.getById(id)).thenReturn(expected);

        // Act
        Optional<InfoEconomica> actual = controller.getById(id);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void testUpdateById() {
        // Arrange
        Long id = 1L;
        InfoEconomica request = new InfoEconomica();
        InfoEconomica expected = new InfoEconomica();
        when(service.updateById(request, id)).thenReturn(expected);

        // Act
        InfoEconomica actual = controller.updateById(request, id);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void testDeleteById() {
        // Arrange
        Long id = 1L;
        when(service.delete(id)).thenReturn(true);

        // Act
        String actual = controller.deleteById(id);

        // Assert
        assertEquals("InfoEconomica eliminado con exito", actual);
    }
}
