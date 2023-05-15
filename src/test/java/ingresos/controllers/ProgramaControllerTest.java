package ingresos.controllers;

import ingresos.domain.Programa;
import ingresos.service.ProgramaService;

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
public class ProgramaControllerTest {

    @Mock
    private ProgramaService service;

    @InjectMocks
    private ProgramaController controller;

    @Test
    public void testGetAll() {
        // Arrange
        List<Programa> expected = new ArrayList<>();
        expected.add(new Programa());
        when(service.getAll()).thenReturn(expected);

        // Act
        List<Programa> actual = controller.getAll();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void testSave() {
        // Arrange
        Programa toSave = new Programa();
        when(service.save(toSave)).thenReturn(toSave);

        // Act
        Programa actual = controller.save(toSave);

        // Assert
        assertEquals(toSave, actual);
    }

    @Test
    public void testGetById() {
        // Arrange
        Long id = 1L;
        Optional<Programa> expected = Optional.of(new Programa());
        when(service.getById(id)).thenReturn(expected);

        // Act
        Optional<Programa> actual = controller.getById(id);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void testUpdateById() {
        // Arrange
        Long id = 1L;
        Programa request = new Programa();
        Programa expected = new Programa();
        when(service.updateById(request, id)).thenReturn(expected);

        // Act
        Programa actual = controller.updateById(request, id);

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
        assertEquals("Programa eliminado con exito", actual);
    }

    @Test
    public void testDeleteByIdNotFound() {
        // Arrange
        Long id = 1L;
        when(service.delete(id)).thenReturn(false);

        // Act
        String actual = controller.deleteById(id);

        // Assert
        assertEquals("No se pude eliminar al Programa", actual);
    }
}
