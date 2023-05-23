package ingresos.service;

import ingresos.models.IngresoEstudiante;
import ingresos.repository.IIngresoEstudianteRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class IngresoEstudianteService {

    @Autowired
    IIngresoEstudianteRepository ingresoEstudianteRepository;

    public List<IngresoEstudiante> getAllIngresosEstudiante() {
        return ingresoEstudianteRepository.findAll();
    }

    public IngresoEstudiante getIngresoEstudianteById(int id) {
        Optional<IngresoEstudiante> ingresoEstudiante = ingresoEstudianteRepository.findById(id);
        if (ingresoEstudiante.isPresent()) {
            return ingresoEstudiante.get();
        } else {
            throw new NoSuchElementException("IngresoEstudiante no encontrado");
        }
    }

    public IngresoEstudiante createIngresoEstudiante(IngresoEstudiante ingresoEstudiante) {
        return ingresoEstudianteRepository.save(ingresoEstudiante);
    }

    public IngresoEstudiante updateIngresoEstudiante(int id, IngresoEstudiante ingresoEstudianteData) {
        Optional<IngresoEstudiante> ingresoEstudiante = ingresoEstudianteRepository.findById(id);
        if (ingresoEstudiante.isPresent()) {
            IngresoEstudiante updatedIngresoEstudiante = ingresoEstudiante.get();

            BeanUtils.copyProperties(ingresoEstudianteData, updatedIngresoEstudiante, "idIngresoEstudiante");

            return ingresoEstudianteRepository.save(updatedIngresoEstudiante);
        } else {
            throw new NoSuchElementException("IngresoEstudiante no encontrado");
        }
    }

    public void deleteIngresoEstudiante(int id) {
        ingresoEstudianteRepository.deleteById(id);
    }
}
