package ingresos.controllers;

import ingresos.models.Estudiante;
import ingresos.service.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/estudiante")
public class EstudianteController {

    @Autowired
    EstudianteService service;

    @GetMapping
    @ResponseBody
    public List<Estudiante> getAllEstudiantes() {
        return service.getAllEstudiantes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Estudiante> getEstudianteById(@PathVariable int id) {
        Estudiante estudiante = service.getEstudianteById(id);
        return ResponseEntity.ok(estudiante);
    }

    @PostMapping
    public ResponseEntity<Estudiante> createEstudiante(@RequestBody Estudiante estudiante) {
        Estudiante createdEstudiante = service.createEstudiante(estudiante);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdEstudiante);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Estudiante> updateEstudiante(@PathVariable int id, @RequestBody Estudiante estudianteData) {
        Estudiante updatedEstudiante = service.updateEstudiante(id, estudianteData);
        return ResponseEntity.ok(updatedEstudiante);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEstudiante(@PathVariable int id) {
        service.deleteEstudiante(id);
        return ResponseEntity.noContent().build();
    }
}
