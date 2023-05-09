package ingresos.service;

import ingresos.domain.InfoBachillerato;
import ingresos.repository.IInfoBachilleratoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InfoBachilleratoService{
    @Autowired
    IInfoBachilleratoRepository repository;

    public InfoBachillerato save(InfoBachillerato toSave){
        return repository.save(toSave);
    }

    public List<InfoBachillerato> getAll(){
        return repository.findAll();
    }

    public Optional<InfoBachillerato> getById(Long id){
        return repository.findById(id);
    }

    public InfoBachillerato updateById(InfoBachillerato request, Long id){
        InfoBachillerato actualizado = repository.findById(id).orElse(null);
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
