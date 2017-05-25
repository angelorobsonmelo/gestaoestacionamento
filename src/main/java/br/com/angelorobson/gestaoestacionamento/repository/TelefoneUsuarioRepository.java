package br.com.angelorobson.gestaoestacionamento.repository;

import br.com.angelorobson.gestaoestacionamento.domain.TelefoneUsuario;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Angelo on 21/05/2017.
 */
public interface TelefoneUsuarioRepository extends JpaRepository<TelefoneUsuario, Long> {
}
