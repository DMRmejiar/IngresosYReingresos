package ingresos.service;

import ingresos.domain.OtroEstudioFormal;
import ingresos.repository.IOtroEstudioFormalRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OtroEstudioFormalService {

    @Autowired
    IOtroEstudioFormalRepository repository;

    public OtroEstudioFormal save(OtroEstudioFormal toSave){
        return repository.save(toSave);
    }

    public List<OtroEstudioFormal> getAll(){
        return repository.findAll();
    }

    public Optional<OtroEstudioFormal> getById(Long id){
        return repository.findById(id);
    }

    public OtroEstudioFormal updateById(OtroEstudioFormal request, Long id){
        OtroEstudioFormal actualizado = repository.findById(id).orElse(null);
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

