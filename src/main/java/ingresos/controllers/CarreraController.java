package ingresos.controllers;

import ingresos.models.Carrera;
import ingresos.service.CarreraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/carrera")
public class CarreraController {
    @Autowired
    CarreraService service;

    @GetMapping
    @ResponseBody
    public List<Carrera> getAllCarreras(){
        return service.getAllCarreras();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Carrera> getCarreraById(@PathVariable int id){
        Carrera carrera = service.getCarreraById(id);
        return ResponseEntity.ok(carrera);
    }

    @PostMapping
    public ResponseEntity<Carrera> createCarrera(@RequestBody Carrera carrera){
        Carrera createdCarrera = service.createCarrera(carrera);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCarrera);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Carrera> updateCarrera(@PathVariable int id, @RequestBody Carrera carreraData){
        Carrera updatedCarrera = service.updateCarrera(id, carreraData);
        return ResponseEntity.ok(updatedCarrera);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCarrera(@PathVariable int id){
        service.deleteCarrera(id);
        return ResponseEntity.noContent().build();
    }
}
