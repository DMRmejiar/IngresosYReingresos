package ingresos.repository;

import ingresos.models.SolicitudReingreso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISolicitudReingresoRepository extends JpaRepository<SolicitudReingreso, Integer> {
}
