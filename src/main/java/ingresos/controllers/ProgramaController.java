package ingresos.controllers;

import ingresos.domain.Programa;
import ingresos.service.ProgramaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Programa")
public class ProgramaController {

    @Autowired
    private ProgramaService service;

    @GetMapping
    public List<Programa> getAll(){
        return this.service.getAll();
    }

    @PostMapping
    public Programa save(@RequestBody Programa toSave){
        return this.service.save(toSave);
    }

    @GetMapping(path = "/{id}")
    public Optional<Programa> getById(Long id){
        return this.service.getById(id);
    }

    @PutMapping(path = "/{id}")
    public Programa updateById(@RequestBody Programa request ,@PathVariable("id") Long id){
        return this.service.updateById(request, id);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteById(@PathVariable("id") Long id){
        Boolean deleted = this.service.delete(id);
        if (deleted) {
            return ("Programa eliminado con exito");
        }else{
            return ("No se pude eliminar al Programa");
        }
    }

}

