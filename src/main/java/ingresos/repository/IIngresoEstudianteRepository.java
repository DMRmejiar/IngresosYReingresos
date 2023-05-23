package ingresos.repository;

import ingresos.models.IngresoEstudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IIngresoEstudianteRepository extends JpaRepository<IngresoEstudiante, Integer> {
}
