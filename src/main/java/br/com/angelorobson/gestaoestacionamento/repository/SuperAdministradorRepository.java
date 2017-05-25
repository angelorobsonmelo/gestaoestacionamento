package br.com.angelorobson.gestaoestacionamento.repository;

import br.com.angelorobson.gestaoestacionamento.domain.SuperAdminstrador;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Angelo on 24/05/2017.
 */
public interface SuperAdministradorRepository extends JpaRepository <SuperAdminstrador, Long> {
}
