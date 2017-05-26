package br.com.angelorobson.gestaoestacionamento.repository;

import br.com.angelorobson.gestaoestacionamento.domain.Funcionario;
import br.com.angelorobson.gestaoestacionamento.domain.TermoMensalista;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Angelo on 11/05/2017.
 */
public interface TermoMensalistaRepository extends JpaRepository<TermoMensalista, Long>{
}
