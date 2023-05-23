package ingresos.controllers;

import ingresos.models.DocumentoReingresoEstudiante;
import ingresos.service.DocumentoReingresoEstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/documento-reingreso-estudiante")
public class DocumentoReingresoEstudianteController {

    @Autowired
    DocumentoReingresoEstudianteService service;


    @GetMapping
    @ResponseBody
    public List<DocumentoReingresoEstudiante> getAllDocumentosReingresoEstudiante() {
        return service.getAllDocumentosReingresoEstudiante();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DocumentoReingresoEstudiante> getDocumentoReingresoEstudianteById(@PathVariable int id) {
        DocumentoReingresoEstudiante documentoReingresoEstudiante = service.getDocumentoReingresoEstudianteById(id);
        return ResponseEntity.ok(documentoReingresoEstudiante);
    }

    @PostMapping
    public ResponseEntity<DocumentoReingresoEstudiante> createDocumentoReingresoEstudiante(@RequestBody DocumentoReingresoEstudiante documentoReingresoEstudiante) {
        DocumentoReingresoEstudiante createdDocumentoReingresoEstudiante = service.createDocumentoReingresoEstudiante(documentoReingresoEstudiante);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdDocumentoReingresoEstudiante);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DocumentoReingresoEstudiante> updateDocumentoReingresoEstudiante(@PathVariable int id, @RequestBody DocumentoReingresoEstudiante documentoReingresoEstudianteData) {
        DocumentoReingresoEstudiante updatedDocumentoReingresoEstudiante = service.updateDocumentoReingresoEstudiante(id, documentoReingresoEstudianteData);
        return ResponseEntity.ok(updatedDocumentoReingresoEstudiante);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDocumentoReingresoEstudiante(@PathVariable int id) {
        service.deleteDocumentoReingresoEstudiante(id);
        return ResponseEntity.noContent().build();
    }
}
