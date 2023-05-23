package ingresos.controllers;

import ingresos.models.Pensum;
import ingresos.service.PensumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/pensum")
public class PensumController {

    @Autowired
    PensumService service;


    @GetMapping
    @ResponseBody
    public List<Pensum> getAllPensums() {
        return service.getAllPensums();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pensum> getPensumById(@PathVariable int id) {
        Pensum pensum = service.getPensumById(id);
        return ResponseEntity.ok(pensum);
    }

    @PostMapping
    public ResponseEntity<Pensum> createPensum(@RequestBody Pensum pensum) {
        Pensum createdPensum = service.createPensum(pensum);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPensum);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pensum> updatePensum(@PathVariable int id, @RequestBody Pensum pensumData) {
        Pensum updatedPensum = service.updatePensum(id, pensumData);
        return ResponseEntity.ok(updatedPensum);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePensum(@PathVariable int id) {
        service.deletePensum(id);
        return ResponseEntity.noContent().build();
    }
}
