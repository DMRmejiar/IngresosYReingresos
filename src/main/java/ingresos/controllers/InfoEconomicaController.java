package ingresos.controllers;

import ingresos.domain.InfoEconomica;
import ingresos.service.InfoEconomicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/info-economica")
public class InfoEconomicaController {

    @Autowired
    private InfoEconomicaService service;

    @GetMapping
    public List<InfoEconomica> getAll(){
        return this.service.getAll();
    }

    @PostMapping
    public InfoEconomica save(@RequestBody InfoEconomica toSave){
        return this.service.save(toSave);
    }

    @GetMapping(path = "/{id}")
    public Optional<InfoEconomica> getById(Long id){
        return this.service.getById(id);
    }

    @PutMapping(path = "/{id}")
    public InfoEconomica updateById(@RequestBody InfoEconomica request ,@PathVariable("id") Long id){
        return this.service.updateById(request, id);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteById(@PathVariable("id") Long id){
        Boolean deleted = this.service.delete(id);
        if (deleted) {
            return ("InfoEconomica eliminado con exito");
        }else{
            return ("No se pude eliminar al InfoEconomica");
        }
    }

}
