package ingresos.repository;

import ingresos.domain.InfoEconomica;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IInfoEconomicaRepository  extends JpaRepository<InfoEconomica, Long> {
}
