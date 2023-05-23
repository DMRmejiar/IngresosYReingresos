package ingresos.service;

import ingresos.models.Estudiante;
import ingresos.repository.IEstudianteRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class EstudianteService {

    @Autowired
    IEstudianteRepository estudianteRepository;

    public List<Estudiante> getAllEstudiantes() {
        return estudianteRepository.findAll();
    }

    public Estudiante getEstudianteById(int id) {
        Optional<Estudiante> estudiante = estudianteRepository.findById(id);
        if (estudiante.isPresent()) {
            return estudiante.get();
        } else {
            throw new NoSuchElementException("Estudiante no encontrado");
        }
    }

    public Estudiante createEstudiante(Estudiante estudiante) {
        return estudianteRepository.save(estudiante);
    }

    public Estudiante updateEstudiante(int id, Estudiante estudianteData) {
        Optional<Estudiante> estudiante = estudianteRepository.findById(id);
        if (estudiante.isPresent()) {
            Estudiante updatedEstudiante = estudiante.get();

            BeanUtils.copyProperties(estudianteData, updatedEstudiante, "idEstudiante");

            return estudianteRepository.save(updatedEstudiante);
        } else {
            throw new NoSuchElementException("Estudiante no encontrado");
        }
    }

    public void deleteEstudiante(int id) {
        estudianteRepository.deleteById(id);
    }
}
