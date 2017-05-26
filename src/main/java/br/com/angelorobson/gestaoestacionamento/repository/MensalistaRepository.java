package br.com.angelorobson.gestaoestacionamento.repository;

import br.com.angelorobson.gestaoestacionamento.domain.Funcionario;
import br.com.angelorobson.gestaoestacionamento.domain.Mensalista;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Angelo on 11/05/2017.
 */
public interface MensalistaRepository extends JpaRepository<Mensalista, Long>{
}
