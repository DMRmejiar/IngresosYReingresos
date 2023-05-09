package ingresos.repository;

import ingresos.domain.Programa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProgramaRepository extends JpaRepository<Programa, Long> {
}
