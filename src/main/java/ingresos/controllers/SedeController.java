package ingresos.controllers;

import ingresos.models.Sede;
import ingresos.service.SedeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/sede")
public class SedeController {

    @Autowired
    SedeService service;

    @GetMapping
    @ResponseBody
    public List<Sede> getAllSedes() {
        return service.getAllSedes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sede> getSedeById(@PathVariable int id) {
        Sede sede = service.getSedeById(id);
        return ResponseEntity.ok(sede);
    }

    @PostMapping
    public ResponseEntity<Sede> createSede(@RequestBody Sede sede) {
        Sede createdSede = service.createSede(sede);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdSede);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Sede> updateSede(@PathVariable int id, @RequestBody Sede sedeData) {
        Sede updatedSede = service.updateSede(id, sedeData);
        return ResponseEntity.ok(updatedSede);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSede(@PathVariable int id) {
        service.deleteSede(id);
        return ResponseEntity.noContent().build();
    }
}
