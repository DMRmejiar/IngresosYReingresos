package ingresos.controllers;

import ingresos.models.IngresoEstudiante;
import ingresos.service.IngresoEstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/ingreso-estudiante")
public class IngresoEstudianteController {

    @Autowired
    IngresoEstudianteService service;

    @GetMapping
    @ResponseBody
    public List<IngresoEstudiante> getAllIngresosEstudiante() {
        return service.getAllIngresosEstudiante();
    }

    @GetMapping("/{id}")
    public ResponseEntity<IngresoEstudiante> getIngresoEstudianteById(@PathVariable int id) {
        IngresoEstudiante ingresoEstudiante = service.getIngresoEstudianteById(id);
        return ResponseEntity.ok(ingresoEstudiante);
    }

    @PostMapping
    public ResponseEntity<IngresoEstudiante> createIngresoEstudiante(@RequestBody IngresoEstudiante ingresoEstudiante) {
        IngresoEstudiante createdIngresoEstudiante = service.createIngresoEstudiante(ingresoEstudiante);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdIngresoEstudiante);
    }

    @PutMapping("/{id}")
    public ResponseEntity<IngresoEstudiante> updateIngresoEstudiante(@PathVariable int id, @RequestBody IngresoEstudiante ingresoEstudianteData) {
        IngresoEstudiante updatedIngresoEstudiante = service.updateIngresoEstudiante(id, ingresoEstudianteData);
        return ResponseEntity.ok(updatedIngresoEstudiante);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteIngresoEstudiante(@PathVariable int id) {
        service.deleteIngresoEstudiante(id);
        return ResponseEntity.noContent().build();
    }
}
