package ingresos.repository;

import ingresos.domain.MatriculaSemestre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMatriculaSemestreRepository extends JpaRepository<MatriculaSemestre, Long> {
}
