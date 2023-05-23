package ingresos.service;

import ingresos.models.DocumentoIngresoEstudiante;
import ingresos.repository.IDocumentoIngresoEstudianteRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class DocumentoIngresoEstudianteService {

    @Autowired
    IDocumentoIngresoEstudianteRepository documentoIngresoEstudianteRepository;

    public List<DocumentoIngresoEstudiante> getAllDocumentosIngresoEstudiante() {
        return documentoIngresoEstudianteRepository.findAll();
    }

    public DocumentoIngresoEstudiante getDocumentoIngresoEstudianteById(int id) {
        Optional<DocumentoIngresoEstudiante> documentoIngresoEstudiante = documentoIngresoEstudianteRepository.findById(id);
        if (documentoIngresoEstudiante.isPresent()) {
            return documentoIngresoEstudiante.get();
        } else {
            throw new NoSuchElementException("Documento de ingreso del estudiante no encontrado");
        }
    }

    public DocumentoIngresoEstudiante createDocumentoIngresoEstudiante(DocumentoIngresoEstudiante documentoIngresoEstudiante) {
        return documentoIngresoEstudianteRepository.save(documentoIngresoEstudiante);
    }

    public DocumentoIngresoEstudiante updateDocumentoIngresoEstudiante(int id, DocumentoIngresoEstudiante documentoIngresoEstudianteData) {
        Optional<DocumentoIngresoEstudiante> documentoIngresoEstudiante = documentoIngresoEstudianteRepository.findById(id);
        if (documentoIngresoEstudiante.isPresent()) {
            DocumentoIngresoEstudiante updatedDocumentoIngresoEstudiante = documentoIngresoEstudiante.get();

            BeanUtils.copyProperties(documentoIngresoEstudianteData, updatedDocumentoIngresoEstudiante, "idDocumento");

            return documentoIngresoEstudianteRepository.save(updatedDocumentoIngresoEstudiante);
        } else {
            throw new NoSuchElementException("Documento de ingreso del estudiante no encontrado");
        }
    }

    public void deleteDocumentoIngresoEstudiante(int id) {
        documentoIngresoEstudianteRepository.deleteById(id);
    }
}
