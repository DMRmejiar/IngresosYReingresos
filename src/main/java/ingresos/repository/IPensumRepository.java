package ingresos.repository;

import ingresos.models.Pensum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPensumRepository extends JpaRepository<Pensum, Integer> {
}
