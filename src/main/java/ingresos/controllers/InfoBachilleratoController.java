package ingresos.controllers;

import ingresos.domain.InfoBachillerato;
import ingresos.service.InfoBachilleratoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/info-bachillerato")
public class InfoBachilleratoController {

    @Autowired
    private InfoBachilleratoService service;

    @GetMapping
    public List<InfoBachillerato> getAll(){
        return this.service.getAll();
    }

    @PostMapping
    public InfoBachillerato save(@RequestBody InfoBachillerato toSave){
        return this.service.save(toSave);
    }

    @GetMapping(path = "/{id}")
    public Optional<InfoBachillerato> getById(Long id){
        return this.service.getById(id);
    }

    @PutMapping(path = "/{id}")
    public InfoBachillerato updateById(@RequestBody InfoBachillerato request ,@PathVariable("id") Long id){
        return this.service.updateById(request, id);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteById(@PathVariable("id") Long id){
        Boolean deleted = this.service.delete(id);
        if (deleted) {
            return ("InfoBachillerato eliminado con exito");
        }else{
            return ("No se pude eliminar al InfoBachillerato");
        }
    }

}
