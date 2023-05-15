package ingresos.controllers;

import ingresos.domain.Estudiante;
import ingresos.service.EstudianteService;

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
public class EstudianteControllerTest {

    @Mock
    private EstudianteService service;

    @InjectMocks
    private EstudianteController controller;

    @Test
    public void testGetAll() {
        // Arrange
        List<Estudiante> expected = new ArrayList<>();
        expected.add(new Estudiante());
        when(service.getAll()).thenReturn(expected);

        // Act
        List<Estudiante> actual = controller.getAll();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void testSave() {
        // Arrange
        Estudiante toSave = new Estudiante();
        when(service.save(toSave)).thenReturn(toSave);

        // Act
        Estudiante actual = controller.save(toSave);

        // Assert
        assertEquals(toSave, actual);
    }

    @Test
    public void testGetById() {
        // Arrange
        Long id = 1L;
        Optional<Estudiante> expected = Optional.of(new Estudiante());
        when(service.getById(id)).thenReturn(expected);

        // Act
        Optional<Estudiante> actual = controller.getById(id);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void testUpdateById() {
        // Arrange
        Long id = 1L;
        Estudiante request = new Estudiante();
        Estudiante expected = new Estudiante();
        when(service.updateById(request, id)).thenReturn(expected);

        // Act
        Estudiante actual = controller.updateById(request, id);

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
        assertEquals("Estudiante eliminado con exito", actual);
    }

    @Test
    public void testDeleteByIdNotFound() {
        // Arrange
        Long id = 1L;
        when(service.delete(id)).thenReturn(false);

        // Act
        String actual = controller.deleteById(id);

        // Assert
        assertEquals("No se pude eliminar al estudiante", actual);
    }
}
