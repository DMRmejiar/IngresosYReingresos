package ingresos.controllers;

import ingresos.domain.Estudiante;
import ingresos.service.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/estudiante")
public class EstudianteController {

    @Autowired
    private EstudianteService service;

    @GetMapping
    public List<Estudiante> getAll(){
        return this.service.getAll();
    }

    @PostMapping
    public Estudiante save(@RequestBody Estudiante toSave){
        return this.service.save(toSave);
    }

    @GetMapping(path = "/{id}")
    public Optional<Estudiante> getById(Long id){
        return this.service.getById(id);
    }

    @PutMapping(path = "/{id}")
    public Estudiante updateById(@RequestBody Estudiante request ,@PathVariable("id") Long id){
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
