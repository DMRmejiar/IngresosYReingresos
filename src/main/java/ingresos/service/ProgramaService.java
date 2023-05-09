package ingresos.service;

import ingresos.domain.Programa;
import ingresos.repository.IProgramaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProgramaService {

    @Autowired
    IProgramaRepository repository;

    public Programa save(Programa toSave){
        return repository.save(toSave);
    }

    public List<Programa> getAll(){
        return repository.findAll();
    }

    public Optional<Programa> getById(Long id){
        return repository.findById(id);
    }

    public Programa updateById(Programa request, Long id){
        Programa actualizado = repository.findById(id).orElse(null);
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
