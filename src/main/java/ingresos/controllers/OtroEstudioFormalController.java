package ingresos.controllers;

import ingresos.domain.OtroEstudioFormal;
import ingresos.service.OtroEstudioFormalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/otro-estudio-formal")
public class OtroEstudioFormalController {

    @Autowired
    private OtroEstudioFormalService service;

    @GetMapping
    public List<OtroEstudioFormal> getAll(){
        return this.service.getAll();
    }

    @PostMapping
    public OtroEstudioFormal save(@RequestBody OtroEstudioFormal toSave){
        return this.service.save(toSave);
    }

    @GetMapping(path = "/{id}")
    public Optional<OtroEstudioFormal> getById(Long id){
        return this.service.getById(id);
    }

    @PutMapping(path = "/{id}")
    public OtroEstudioFormal updateById(@RequestBody OtroEstudioFormal request ,@PathVariable("id") Long id){
        return this.service.updateById(request, id);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteById(@PathVariable("id") Long id){
        Boolean deleted = this.service.delete(id);
        if (deleted) {
            return ("OtroEstudioFormal eliminado con exito");
        }else{
            return ("No se pude eliminar al OtroEstudioFormal");
        }
    }

}
