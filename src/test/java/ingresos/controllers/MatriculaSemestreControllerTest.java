package ingresos.controllers;

import ingresos.domain.MatriculaSemestre;
import ingresos.service.MatriculaSemestreService;

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
public class MatriculaSemestreControllerTest {

    @Mock
    private MatriculaSemestreService service;

    @InjectMocks
    private MatriculaSemestreController controller;

    @Test
    public void testGetAll() {
        // Arrange
        List<MatriculaSemestre> expected = new ArrayList<>();
        expected.add(new MatriculaSemestre());
        when(service.getAll()).thenReturn(expected);

        // Act
        List<MatriculaSemestre> actual = controller.getAll();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void testSave() {
        // Arrange
        MatriculaSemestre toSave = new MatriculaSemestre();
        when(service.save(toSave)).thenReturn(toSave);

        // Act
        MatriculaSemestre actual = controller.save(toSave);

        // Assert
        assertEquals(toSave, actual);
    }

    @Test
    public void testGetById() {
        // Arrange
        Long id = 1L;
        Optional<MatriculaSemestre> expected = Optional.of(new MatriculaSemestre());
        when(service.getById(id)).thenReturn(expected);

        // Act
        Optional<MatriculaSemestre> actual = controller.getById(id);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void testUpdateById() {
        // Arrange
        Long id = 1L;
        MatriculaSemestre request = new MatriculaSemestre();
        MatriculaSemestre expected = new MatriculaSemestre();
        when(service.updateById(request, id)).thenReturn(expected);

        // Act
        MatriculaSemestre actual = controller.updateById(request, id);

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
        assertEquals("MatriculaSemestre eliminado con exito", actual);
    }
}
