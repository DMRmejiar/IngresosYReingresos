package ingresos.controllers;

import ingresos.domain.InfoAcademica;
import ingresos.service.InfoAcademicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/info-academica")
public class InfoAcademicaController {

    @Autowired
    private InfoAcademicaService service;

    @GetMapping
    public List<InfoAcademica> getAll(){
        return this.service.getAll();
    }

    @PostMapping
    public InfoAcademica save(@RequestBody InfoAcademica toSave){
        return this.service.save(toSave);
    }

    @GetMapping(path = "/{id}")
    public Optional<InfoAcademica> getById(Long id){
        return this.service.getById(id);
    }

    @PutMapping(path = "/{id}")
    public InfoAcademica updateUserById(@RequestBody InfoAcademica request ,@PathVariable("id") Long id){
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
