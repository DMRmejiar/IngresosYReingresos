package ingresos.service;

import ingresos.domain.Estudiante;
import ingresos.repository.IEstudianteRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstudianteService {

    @Autowired
    IEstudianteRepository repository;

    public Estudiante save(Estudiante toSave){
        return repository.save(toSave);
    }

    public List<Estudiante> getAll(){
        return repository.findAll();
    }

    public Optional<Estudiante> getById(Long id){
        return repository.findById(id);
    }

    public Estudiante updateById(Estudiante request, Long id){
        Estudiante actualizado = repository.findById(id).orElse(null);
        if (actualizado != null){
            BeanUtils.copyProperties(request, actualizado, "id");
            return repository.save(actualizado);
        }
        return null;
    }

    public Boolean delete(Long id){
        try{
            repository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
