package ingresos.service;

import ingresos.models.Sede;
import ingresos.repository.ISedeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class SedeService {

    @Autowired
    ISedeRepository sedeRepository;

    public List<Sede> getAllSedes() {
        return sedeRepository.findAll();
    }

    public Sede getSedeById(int id) {
        Optional<Sede> sede = sedeRepository.findById(id);
        if (sede.isPresent()) {
            return sede.get();
        } else {
            throw new NoSuchElementException("Sede no encontrada");
        }
    }

    public Sede createSede(Sede sede) {
        return sedeRepository.save(sede);
    }

    public Sede updateSede(int id, Sede sedeData) {
        Optional<Sede> sede = sedeRepository.findById(id);
        if (sede.isPresent()) {
            Sede updatedSede = sede.get();

            BeanUtils.copyProperties(sedeData, updatedSede, "sede");

            return sedeRepository.save(updatedSede);
        } else {
            throw new NoSuchElementException("Sede no encontrada");
        }
    }

    public void deleteSede(int id) {
        sedeRepository.deleteById(id);
    }
}
