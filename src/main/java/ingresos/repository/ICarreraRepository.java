package ingresos.repository;

import ingresos.models.Carrera;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICarreraRepository extends JpaRepository<Carrera, Integer> {
}
