package ingresos.controllers;

import ingresos.models.DocumentoIngresoEstudiante;
import ingresos.service.DocumentoIngresoEstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/documento-ingreso-estudiante")
public class DocumentoIngresoEstudianteController {

    @Autowired
    DocumentoIngresoEstudianteService service;

    @GetMapping
    @ResponseBody
    public List<DocumentoIngresoEstudiante> getAllDocumentosIngresoEstudiante() {
        return service.getAllDocumentosIngresoEstudiante();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DocumentoIngresoEstudiante> getDocumentoIngresoEstudianteById(@PathVariable int id) {
        DocumentoIngresoEstudiante documentoIngresoEstudiante = service.getDocumentoIngresoEstudianteById(id);
        return ResponseEntity.ok(documentoIngresoEstudiante);
    }

    @PostMapping
    public ResponseEntity<DocumentoIngresoEstudiante> createDocumentoIngresoEstudiante(@RequestBody DocumentoIngresoEstudiante documentoIngresoEstudiante) {
        DocumentoIngresoEstudiante createdDocumentoIngresoEstudiante = service.createDocumentoIngresoEstudiante(documentoIngresoEstudiante);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdDocumentoIngresoEstudiante);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DocumentoIngresoEstudiante> updateDocumentoIngresoEstudiante(@PathVariable int id, @RequestBody DocumentoIngresoEstudiante documentoIngresoEstudianteData) {
        DocumentoIngresoEstudiante updatedDocumentoIngresoEstudiante = service.updateDocumentoIngresoEstudiante(id, documentoIngresoEstudianteData);
        return ResponseEntity.ok(updatedDocumentoIngresoEstudiante);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDocumentoIngresoEstudiante(@PathVariable int id) {
        service.deleteDocumentoIngresoEstudiante(id);
        return ResponseEntity.noContent().build();
    }
}
