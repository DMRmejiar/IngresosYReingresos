package ingresos.controllers;

import ingresos.domain.Usuario;
import ingresos.service.UsuarioService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class UsuarioControllerTest {

    @Mock
    private UsuarioService service;

    @InjectMocks
    private UsuarioController controller;

    @Test
    public void testGetAll() {
        // Arrange
        List<Usuario> expected = new ArrayList<>();
        expected.add(new Usuario());
        when(service.getAll()).thenReturn(expected);

        // Act
        List<Usuario> actual = controller.getAll();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void testSave() {
        // Arrange
        Usuario toSave = new Usuario();
        when(service.save(toSave)).thenReturn(toSave);

        // Act
        Usuario actual = controller.save(toSave);

        // Assert
        assertEquals(toSave, actual);
    }

    @Test
    public void testGetById() {
        // Arrange
        Long id = 1L;
        Optional<Usuario> expected = Optional.of(new Usuario());
        when(service.getById(id)).thenReturn(expected);

        // Act
        Optional<Usuario> actual = controller.getById(id);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void testUpdateById() {
        // Arrange
        Long id = 1L;
        Usuario request = new Usuario();
        Usuario expected = new Usuario();
        when(service.updateById(request, id)).thenReturn(expected);

        // Act
        Usuario actual = controller.updateById(request, id);

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
        assertEquals("Usuario eliminado con exito", actual);
    }

    @Test
    public void testDeleteByIdNotFound() {
        // Arrange
        Long id = 1L;
        when(service.delete(id)).thenReturn(false);

        // Act
        String actual = controller.deleteById(id);

        // Assert
        assertEquals("No se pude eliminar al Usuario", actual);
    }
}
