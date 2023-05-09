package ingresos.controllers;

import ingresos.domain.Usuario;
import ingresos.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @GetMapping
    public List<Usuario> getAll(){
        return this.service.getAll();
    }

    @PostMapping
    public Usuario save(@RequestBody Usuario toSave){
        return this.service.save(toSave);
    }

    @GetMapping(path = "/{id}")
    public Optional<Usuario> getById(Long id){
        return this.service.getById(id);
    }

    @PutMapping(path = "/{id}")
    public Usuario updateById(@RequestBody Usuario request ,@PathVariable("id") Long id){
        return this.service.updateById(request, id);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteById(@PathVariable("id") Long id){
        Boolean deleted = this.service.delete(id);
        if (deleted) {
            return ("Usuario eliminado con exito");
        }else{
            return ("No se pude eliminar al Usuario");
        }
    }

}
