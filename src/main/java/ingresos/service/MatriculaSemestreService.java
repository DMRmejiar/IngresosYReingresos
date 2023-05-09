package ingresos.service;

import ingresos.domain.MatriculaSemestre;
import ingresos.repository.IMatriculaSemestreRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MatriculaSemestreService {

    @Autowired
    IMatriculaSemestreRepository repository;

    public MatriculaSemestre save(MatriculaSemestre toSave){
        return repository.save(toSave);
    }

    public List<MatriculaSemestre> getAll(){
        return repository.findAll();
    }

    public Optional<MatriculaSemestre> getById(Long id){
        return repository.findById(id);
    }

    public MatriculaSemestre updateById(MatriculaSemestre request, Long id){
        MatriculaSemestre actualizado = repository.findById(id).orElse(null);
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
