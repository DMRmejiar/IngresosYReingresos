package ingresos.controllers;

import ingresos.models.Materia;
import ingresos.service.MateriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/materia")
public class MateriaController {

    @Autowired
    MateriaService service;


    @GetMapping
    @ResponseBody
    public List<Materia> getAllMaterias() {
        return service.getAllMaterias();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Materia> getMateriaById(@PathVariable int id) {
        Materia materia = service.getMateriaById(id);
        return ResponseEntity.ok(materia);
    }

    @PostMapping
    public ResponseEntity<Materia> createMateria(@RequestBody Materia materia) {
        Materia createdMateria = service.createMateria(materia);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdMateria);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Materia> updateMateria(@PathVariable int id, @RequestBody Materia materiaData) {
        Materia updatedMateria = service.updateMateria(id, materiaData);
        return ResponseEntity.ok(updatedMateria);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMateria(@PathVariable int id) {
        service.deleteMateria(id);
        return ResponseEntity.noContent().build();
    }
}
