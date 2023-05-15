package ingresos.controllers;

import ingresos.domain.InfoBachillerato;
import ingresos.service.InfoBachilleratoService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
@ExtendWith(MockitoExtension.class)
public class InfoBachilleratoControllerTest {

    @Mock
    private InfoBachilleratoService service;

    @InjectMocks
    private InfoBachilleratoController controller;

    @Test
    public void testGetAll() {
        // Arrange
        List<InfoBachillerato> expected = new ArrayList<>();
        expected.add(new InfoBachillerato());
        when(service.getAll()).thenReturn(expected);

        // Act
        List<InfoBachillerato> actual = controller.getAll();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void testSave() {
        // Arrange
        InfoBachillerato toSave = new InfoBachillerato();
        when(service.save(toSave)).thenReturn(toSave);

        // Act
        InfoBachillerato actual = controller.save(toSave);

        // Assert
        assertEquals(toSave, actual);
    }

    @Test
    public void testGetById() {
        // Arrange
        Long id = 1L;
        Optional<InfoBachillerato> expected = Optional.of(new InfoBachillerato());
        when(service.getById(id)).thenReturn(expected);

        // Act
        Optional<InfoBachillerato> actual = controller.getById(id);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void testUpdateById() {
        // Arrange
        Long id = 1L;
        InfoBachillerato request = new InfoBachillerato();
        InfoBachillerato expected = new InfoBachillerato();
        when(service.updateById(request, id)).thenReturn(expected);

        // Act
        InfoBachillerato actual = controller.updateById(request, id);

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
        assertEquals("InfoBachillerato eliminado con exito", actual);
    }
}
