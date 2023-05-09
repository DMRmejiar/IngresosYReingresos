package ingresos.repository;

import ingresos.domain.InfoPersonal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IInfoPersonalRepository extends JpaRepository<InfoPersonal, Long> {

}
