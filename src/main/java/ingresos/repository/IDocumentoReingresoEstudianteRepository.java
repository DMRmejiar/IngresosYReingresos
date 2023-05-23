package ingresos.repository;

import ingresos.models.DocumentoReingresoEstudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDocumentoReingresoEstudianteRepository extends JpaRepository<DocumentoReingresoEstudiante, Integer> {
}
