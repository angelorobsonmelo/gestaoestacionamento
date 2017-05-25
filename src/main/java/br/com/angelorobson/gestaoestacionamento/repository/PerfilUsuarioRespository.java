package br.com.angelorobson.gestaoestacionamento.repository;

import br.com.angelorobson.gestaoestacionamento.domain.PerfilUsuario;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Angelo on 24/05/2017.
 */
public interface PerfilUsuarioRespository extends JpaRepository <PerfilUsuario, Long> {
}
