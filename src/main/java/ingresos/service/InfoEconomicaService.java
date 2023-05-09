package ingresos.service;

import ingresos.domain.InfoEconomica;
import ingresos.repository.IInfoEconomicaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InfoEconomicaService {

    @Autowired
    IInfoEconomicaRepository repository;

    public InfoEconomica save(InfoEconomica toSave){
        return repository.save(toSave);
    }

    public List<InfoEconomica> getAll(){
        return repository.findAll();
    }

    public Optional<InfoEconomica> getById(Long id){
        return repository.findById(id);
    }

    public InfoEconomica updateById(InfoEconomica request, Long id){
        InfoEconomica actualizado = repository.findById(id).orElse(null);
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
