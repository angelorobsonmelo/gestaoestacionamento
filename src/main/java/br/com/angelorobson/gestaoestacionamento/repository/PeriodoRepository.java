package br.com.angelorobson.gestaoestacionamento.repository;

import br.com.angelorobson.gestaoestacionamento.domain.Periodo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Angelo on 22/05/2017.
 */
public interface PeriodoRepository extends JpaRepository<Periodo, Long> {

}
