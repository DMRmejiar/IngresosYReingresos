package ingresos.service;

import ingresos.domain.InfoAcademica;
import ingresos.repository.IInfoAcademicaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InfoAcademicaService {
    @Autowired
    IInfoAcademicaRepository repository;

    public InfoAcademica save(InfoAcademica toSave){
        return repository.save(toSave);
    }

    public List<InfoAcademica> getAll(){
        return repository.findAll();
    }

    public Optional<InfoAcademica> getById(Long id){
        return repository.findById(id);
    }

    public InfoAcademica updateById(InfoAcademica request, Long id){
        InfoAcademica actualizado = repository.findById(id).orElse(null);
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
