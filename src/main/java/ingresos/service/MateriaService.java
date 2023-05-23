package ingresos.service;

import ingresos.models.Materia;
import ingresos.repository.IMateriaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class MateriaService {

    @Autowired
    IMateriaRepository materiaRepository;

    public List<Materia> getAllMaterias() {
        return materiaRepository.findAll();
    }

    public Materia getMateriaById(int id) {
        Optional<Materia> materia = materiaRepository.findById(id);
        if (materia.isPresent()) {
            return materia.get();
        } else {
            throw new NoSuchElementException("Materia no encontrada");
        }
    }

    public Materia createMateria(Materia materia) {
        return materiaRepository.save(materia);
    }

    public Materia updateMateria(int id, Materia materiaData) {
        Optional<Materia> materia = materiaRepository.findById(id);
        if (materia.isPresent()) {
            Materia updatedMateria = materia.get();

            BeanUtils.copyProperties(materiaData, updatedMateria, "idMateria");

            return materiaRepository.save(updatedMateria);
        } else {
            throw new NoSuchElementException("Materia no encontrada");
        }
    }

    public void deleteMateria(int id) {
        materiaRepository.deleteById(id);
    }
}
