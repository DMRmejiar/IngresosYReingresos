package ingresos.service;

import ingresos.domain.Usuario;
import ingresos.repository.IUsuarioRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    IUsuarioRepository repository;

    public Usuario save(Usuario toSave){
        return repository.save(toSave);
    }

    public List<Usuario> getAll(){
        return repository.findAll();
    }

    public Optional<Usuario> getById(Long id){
        return repository.findById(id);
    }

    public Usuario updateById(Usuario request, Long id){
        Usuario actualizado = repository.findById(id).orElse(null);
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
