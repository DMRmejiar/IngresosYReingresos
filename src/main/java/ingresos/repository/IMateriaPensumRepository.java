package ingresos.repository;

import ingresos.models.MateriaPensum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMateriaPensumRepository extends JpaRepository<MateriaPensum, Integer> {
}
