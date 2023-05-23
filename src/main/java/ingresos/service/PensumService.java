package ingresos.service;

import ingresos.models.Pensum;
import ingresos.repository.IPensumRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class PensumService {

    @Autowired
    IPensumRepository pensumRepository;

    public List<Pensum> getAllPensums() {
        return pensumRepository.findAll();
    }

    public Pensum getPensumById(int id) {
        Optional<Pensum> pensum = pensumRepository.findById(id);
        if (pensum.isPresent()) {
            return pensum.get();
        } else {
            throw new NoSuchElementException("Pensum no encontrado");
        }
    }

    public Pensum createPensum(Pensum pensum) {
        return pensumRepository.save(pensum);
    }

    public Pensum updatePensum(int id, Pensum pensumData) {
        Optional<Pensum> pensum = pensumRepository.findById(id);
        if (pensum.isPresent()) {
            Pensum updatedPensum = pensum.get();

            BeanUtils.copyProperties(pensumData, updatedPensum, "idPensum");

            return pensumRepository.save(updatedPensum);
        } else {
            throw new NoSuchElementException("Pensum no encontrado");
        }
    }

    public void deletePensum(int id) {
        pensumRepository.deleteById(id);
    }
}
