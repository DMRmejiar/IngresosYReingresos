package ingresos.service;

import ingresos.domain.InfoPersonal;
import ingresos.repository.IInfoPersonalRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class InfoPersonalService {
    @Autowired
    IInfoPersonalRepository repository;

    public InfoPersonal save(InfoPersonal info){
        return repository.save(info);
    }

    public List<InfoPersonal> getAll(){
        return repository.findAll();
    }

    public Optional<InfoPersonal> getById(Long id){
        return repository.findById(id);
    }

    public InfoPersonal updateById(InfoPersonal request, Long id){
        InfoPersonal actualizado = repository.findById(id).orElse(null);
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
