package ingresos.service;

import ingresos.models.DocumentoReingresoEstudiante;
import ingresos.repository.IDocumentoReingresoEstudianteRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class DocumentoReingresoEstudianteService {

    @Autowired
    IDocumentoReingresoEstudianteRepository documentoReingresoEstudianteRepository;

    public List<DocumentoReingresoEstudiante> getAllDocumentosReingresoEstudiante() {
        return documentoReingresoEstudianteRepository.findAll();
    }

    public DocumentoReingresoEstudiante getDocumentoReingresoEstudianteById(int id) {
        Optional<DocumentoReingresoEstudiante> documentoReingresoEstudiante = documentoReingresoEstudianteRepository.findById(id);
        if (documentoReingresoEstudiante.isPresent()) {
            return documentoReingresoEstudiante.get();
        } else {
            throw new NoSuchElementException("Documento de reingreso del estudiante no encontrado");
        }
    }

    public DocumentoReingresoEstudiante createDocumentoReingresoEstudiante(DocumentoReingresoEstudiante documentoReingresoEstudiante) {
        return documentoReingresoEstudianteRepository.save(documentoReingresoEstudiante);
    }

    public DocumentoReingresoEstudiante updateDocumentoReingresoEstudiante(int id, DocumentoReingresoEstudiante documentoReingresoEstudianteData) {
        Optional<DocumentoReingresoEstudiante> documentoReingresoEstudiante = documentoReingresoEstudianteRepository.findById(id);
        if (documentoReingresoEstudiante.isPresent()) {
            DocumentoReingresoEstudiante updatedDocumentoReingresoEstudiante = documentoReingresoEstudiante.get();

            BeanUtils.copyProperties(documentoReingresoEstudianteData, updatedDocumentoReingresoEstudiante, "idDocumento");

            return documentoReingresoEstudianteRepository.save(updatedDocumentoReingresoEstudiante);
        } else {
            throw new NoSuchElementException("Documento de reingreso del estudiante no encontrado");
        }
    }

    public void deleteDocumentoReingresoEstudiante(int id) {
        documentoReingresoEstudianteRepository.deleteById(id);
    }
}
