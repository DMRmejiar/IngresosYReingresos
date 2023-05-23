package ingresos.repository;

import ingresos.models.Sede;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISedeRepository extends JpaRepository<Sede, Integer> {
}
