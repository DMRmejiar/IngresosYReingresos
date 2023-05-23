package ingresos.controllers;

import ingresos.models.SolicitudReingreso;
import ingresos.service.SolicitudReingresoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/solicitud-reingreso")
public class SolicitudReingresoController {

    @Autowired
    SolicitudReingresoService service;

    @GetMapping
    @ResponseBody
    public List<SolicitudReingreso> getAllSolicitudesReingreso() {
        return service.getAllSolicitudesReingreso();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SolicitudReingreso> getSolicitudReingresoById(@PathVariable int id) {
        SolicitudReingreso solicitudReingreso = service.getSolicitudReingresoById(id);
        return ResponseEntity.ok(solicitudReingreso);
    }

    @PostMapping
    public ResponseEntity<SolicitudReingreso> createSolicitudReingreso(@RequestBody SolicitudReingreso solicitudReingreso) {
        SolicitudReingreso createdSolicitudReingreso = service.createSolicitudReingreso(solicitudReingreso);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdSolicitudReingreso);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SolicitudReingreso> updateSolicitudReingreso(@PathVariable int id, @RequestBody SolicitudReingreso solicitudReingresoData) {
        SolicitudReingreso updatedSolicitudReingreso = service.updateSolicitudReingreso(id, solicitudReingresoData);
        return ResponseEntity.ok(updatedSolicitudReingreso);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSolicitudReingreso(@PathVariable int id) {
        service.deleteSolicitudReingreso(id);
        return ResponseEntity.noContent().build();
    }
}
