package ingresos.controllers;

import ingresos.domain.MatriculaSemestre;
import ingresos.service.MatriculaSemestreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/matricula-semestre")
public class MatriculaSemestreController {

    @Autowired
    private MatriculaSemestreService service;

    @GetMapping
    public List<MatriculaSemestre> getAll(){
        return this.service.getAll();
    }

    @PostMapping
    public MatriculaSemestre save(@RequestBody MatriculaSemestre toSave){
        return this.service.save(toSave);
    }

    @GetMapping(path = "/{id}")
    public Optional<MatriculaSemestre> getById(Long id){
        return this.service.getById(id);
    }

    @PutMapping(path = "/{id}")
    public MatriculaSemestre updateById(@RequestBody MatriculaSemestre request ,@PathVariable("id") Long id){
        return this.service.updateById(request, id);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteById(@PathVariable("id") Long id){
        Boolean deleted = this.service.delete(id);
        if (deleted) {
            return ("MatriculaSemestre eliminado con exito");
        }else{
            return ("No se pude eliminar al MatriculaSemestre");
        }
    }

}

