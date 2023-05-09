package ingresos.controllers;

import ingresos.domain.InfoPersonal;
import ingresos.service.InfoPersonalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/info-personal")
public class InfoPersonalController {

    @Autowired
    private InfoPersonalService service;

    @GetMapping
    public List<InfoPersonal> getAll(){
        return this.service.getAll();
    }

    @PostMapping
    public InfoPersonal save(@RequestBody InfoPersonal toSave){
        return this.service.save(toSave);
    }

    @GetMapping(path = "/{id}")
    public Optional<InfoPersonal> getById(Long id){
        return this.service.getById(id);
    }

    @PutMapping(path = "/{id}")
    public InfoPersonal updateUserById(@RequestBody InfoPersonal request ,@PathVariable("id") Long id){
        return this.service.updateById(request, id);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteById(@PathVariable("id") Long id){
        Boolean deleted = this.service.delete(id);
        if (deleted) {
            return ("Estudiante eliminado con exito");
        }else{
            return ("No se pude eliminar al estudiante");
        }
    }

}
