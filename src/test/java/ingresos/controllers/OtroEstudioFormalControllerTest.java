package ingresos.controllers;

import ingresos.domain.OtroEstudioFormal;
import ingresos.service.OtroEstudioFormalService;
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
public class OtroEstudioFormalControllerTest {

    @Mock
    private OtroEstudioFormalService service;

    @InjectMocks
    private OtroEstudioFormalController controller;

    @Test
    public void testGetAll() {
        // Arrange
        List<OtroEstudioFormal> expected = new ArrayList<>();
        expected.add(new OtroEstudioFormal());
        when(service.getAll()).thenReturn(expected);

        // Act
        List<OtroEstudioFormal> actual = controller.getAll();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void testSave() {
        // Arrange
        OtroEstudioFormal toSave = new OtroEstudioFormal();
        when(service.save(toSave)).thenReturn(toSave);

        // Act
        OtroEstudioFormal actual = controller.save(toSave);

        // Assert
        assertEquals(toSave, actual);
    }

    @Test
    public void testGetById() {
        // Arrange
        Long id = 1L;
        Optional<OtroEstudioFormal> expected = Optional.of(new OtroEstudioFormal());
        when(service.getById(id)).thenReturn(expected);

        // Act
        Optional<OtroEstudioFormal> actual = controller.getById(id);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void testUpdateById() {
        // Arrange
        Long id = 1L;
        OtroEstudioFormal request = new OtroEstudioFormal();
        OtroEstudioFormal expected = new OtroEstudioFormal();
        when(service.updateById(request, id)).thenReturn(expected);

        // Act
        OtroEstudioFormal actual = controller.updateById(request, id);

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
        assertEquals("OtroEstudioFormal eliminado con exito", actual);
    }
}
