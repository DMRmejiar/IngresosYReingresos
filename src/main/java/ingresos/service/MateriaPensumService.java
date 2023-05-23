package ingresos.service;

import ingresos.models.MateriaPensum;
import ingresos.repository.IMateriaPensumRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class MateriaPensumService {

    @Autowired
    IMateriaPensumRepository materiaPensumRepository;

    public List<MateriaPensum> getAllMateriasPensum() {
        return materiaPensumRepository.findAll();
    }

    public MateriaPensum getMateriaPensumById(int id) {
        Optional<MateriaPensum> materiaPensum = materiaPensumRepository.findById(id);
        if (materiaPensum.isPresent()) {
            return materiaPensum.get();
        } else {
            throw new NoSuchElementException("MateriaPensum no encontrado");
        }
    }

    public MateriaPensum createMateriaPensum(MateriaPensum materiaPensum) {
        return materiaPensumRepository.save(materiaPensum);
    }

    public MateriaPensum updateMateriaPensum(int id, MateriaPensum materiaPensumData) {
        Optional<MateriaPensum> materiaPensum = materiaPensumRepository.findById(id);
        if (materiaPensum.isPresent()) {
            MateriaPensum updatedMateriaPensum = materiaPensum.get();

            BeanUtils.copyProperties(materiaPensumData, updatedMateriaPensum, "idMatCarrera");

            return materiaPensumRepository.save(updatedMateriaPensum);
        } else {
            throw new NoSuchElementException("MateriaPensum no encontrado");
        }
    }

    public void deleteMateriaPensum(int id) {
        materiaPensumRepository.deleteById(id);
    }
}
