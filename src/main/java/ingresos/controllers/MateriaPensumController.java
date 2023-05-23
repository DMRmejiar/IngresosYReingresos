package ingresos.controllers;

import ingresos.models.MateriaPensum;
import ingresos.service.MateriaPensumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/materia-pensum")
public class MateriaPensumController {

    @Autowired
    MateriaPensumService service;


    @GetMapping
    @ResponseBody
    public List<MateriaPensum> getAllMateriasPensum() {
        return service.getAllMateriasPensum();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MateriaPensum> getMateriaPensumById(@PathVariable int id) {
        MateriaPensum materiaPensum = service.getMateriaPensumById(id);
        return ResponseEntity.ok(materiaPensum);
    }

    @PostMapping
    public ResponseEntity<MateriaPensum> createMateriaPensum(@RequestBody MateriaPensum materiaPensum) {
        MateriaPensum createdMateriaPensum = service.createMateriaPensum(materiaPensum);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdMateriaPensum);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MateriaPensum> updateMateriaPensum(@PathVariable int id, @RequestBody MateriaPensum materiaPensumData) {
        MateriaPensum updatedMateriaPensum = service.updateMateriaPensum(id, materiaPensumData);
        return ResponseEntity.ok(updatedMateriaPensum);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMateriaPensum(@PathVariable int id) {
        service.deleteMateriaPensum(id);
        return ResponseEntity.noContent().build();
    }
}
