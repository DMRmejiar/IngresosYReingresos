package ingresos.repository;

import ingresos.models.DocumentoIngresoEstudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDocumentoIngresoEstudianteRepository extends JpaRepository<DocumentoIngresoEstudiante, Integer> {
}
