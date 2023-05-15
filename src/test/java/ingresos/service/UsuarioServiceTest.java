package ingresos.service;
import ingresos.domain.Usuario;
import ingresos.repository.IUsuarioRepository;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.dao.EmptyResultDataAccessException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;
@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class UsuarioServiceTest {

    @Mock
    private IUsuarioRepository repository;

    @InjectMocks
    private UsuarioService service;

    @Test
    public void testSave() {
        // Arrange
        Usuario toSave = new Usuario();
        when(repository.save(toSave)).thenReturn(toSave);

        // Act
        Usuario actual = service.save(toSave);

        // Assert
        assertEquals(toSave, actual);
    }

    @Test
    public void testGetAll() {
        // Arrange
        List<Usuario> expected = new ArrayList<>();
        expected.add(new Usuario());
        when(repository.findAll()).thenReturn(expected);

        // Act
        List<Usuario> actual = service.getAll();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void testGetById() {
        // Arrange
        Long id = 1L;
        Optional<Usuario> expected = Optional.of(new Usuario());
        when(repository.findById(id)).thenReturn(expected);

        // Act
        Optional<Usuario> actual = service.getById(id);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void testUpdateById() {
        // Arrange
        Long id = 1L;
        Usuario request = new Usuario();
        Usuario expected = new Usuario();
        when(repository.findById(id)).thenReturn(Optional.of(expected));
        when(repository.save(expected)).thenReturn(expected);

        // Act
        Usuario actual = service.updateById(request, id);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void testDelete() {
        // Arrange
        Long id = 1L;
        doNothing().when(repository).deleteById(id);

        // Act
        Boolean actual = service.delete(id);

        // Assert
        assertTrue(actual);
    }

    @Test
    public void testDeleteNotFound() {
        // Arrange
        Long id = 1L;
        doThrow(EmptyResultDataAccessException.class).when(repository).deleteById(id);

        // Act
        Boolean actual = service.delete(id);

        // Assert
        assertFalse(actual);
    }
}
