package ingresos.repository;

import ingresos.domain.InfoAcademica;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IInfoAcademicaRepository extends JpaRepository<InfoAcademica, Long> {

}
