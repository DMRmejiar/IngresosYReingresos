package ingresos.service;

import ingresos.domain.Programa;
import ingresos.repository.IProgramaRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ProgramaServiceTest {

    @Mock
    private IProgramaRepository repository;

    @InjectMocks
    private ProgramaService service;

    @Test
    public void testSave() {
        // Arrange
        Programa toSave = new Programa();
        when(repository.save(toSave)).thenReturn(toSave);

        // Act
        Programa actual = service.save(toSave);

        // Assert
        assertEquals(toSave, actual);
    }

    @Test
    public void testGetAll() {
        // Arrange
        List<Programa> expected = new ArrayList<>();
        expected.add(new Programa());
        when(repository.findAll()).thenReturn(expected);

        // Act
        List<Programa> actual = service.getAll();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void testGetById() {
        // Arrange
        Long id = 1L;
        Optional<Programa> expected = Optional.of(new Programa());
        when(repository.findById(id)).thenReturn(expected);

        // Act
        Optional<Programa> actual = service.getById(id);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void testUpdateById() {
        // Arrange
        Long id = 1L;
        Programa request = new Programa();
        Programa expected = new Programa();
        when(repository.findById(id)).thenReturn(Optional.of(expected));
        when(repository.save(expected)).thenReturn(expected);

        // Act
        Programa actual = service.updateById(request, id);

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
