package br.com.angelorobson.gestaoestacionamento.repository;

import br.com.angelorobson.gestaoestacionamento.domain.Proprietario;
import br.com.angelorobson.gestaoestacionamento.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Angelo on 11/05/2017.
 */
public interface ProprietarioRepository extends JpaRepository<Proprietario, Long>{
}
