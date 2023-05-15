package ingresos.controllers;

import ingresos.domain.InfoPersonal;
import ingresos.service.InfoPersonalService;
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
public class InfoPersonalControllerTest {

    @Mock
    private InfoPersonalService service;

    @InjectMocks
    private InfoPersonalController controller;

    @Test
    public void testGetAll() {
        // Arrange
        List<InfoPersonal> expected = new ArrayList<>();
        expected.add(new InfoPersonal());
        when(service.getAll()).thenReturn(expected);

        // Act
        List<InfoPersonal> actual = controller.getAll();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void testSave() {
        // Arrange
        InfoPersonal toSave = new InfoPersonal();
        when(service.save(toSave)).thenReturn(toSave);

        // Act
        InfoPersonal actual = controller.save(toSave);

        // Assert
        assertEquals(toSave, actual);
    }

    @Test
    public void testGetById() {
        // Arrange
        Long id = 1L;
        Optional<InfoPersonal> expected = Optional.of(new InfoPersonal());
        when(service.getById(id)).thenReturn(expected);

        // Act
        Optional<InfoPersonal> actual = controller.getById(id);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void testUpdateById() {
        // Arrange
        Long id = 1L;
        InfoPersonal request = new InfoPersonal();
        InfoPersonal expected = new InfoPersonal();
        when(service.updateById(request, id)).thenReturn(expected);

        // Act
        InfoPersonal actual = controller.updateUserById(request, id);

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
}
