package br.com.angelorobson.gestaoestacionamento.repository;

import br.com.angelorobson.gestaoestacionamento.domain.PrecoCategoriaVeiculoPeriodo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Angelo on 25/05/2017.
 */
@Repository
public interface PrecoCategoriaVeiculoPeriodoRepository extends JpaRepository <PrecoCategoriaVeiculoPeriodo, Long>{
}
