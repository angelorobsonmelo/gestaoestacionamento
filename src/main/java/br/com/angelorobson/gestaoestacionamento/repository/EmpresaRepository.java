package br.com.angelorobson.gestaoestacionamento.repository;

import br.com.angelorobson.gestaoestacionamento.domain.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Angelo on 25/05/2017.
 */
public interface EmpresaRepository extends JpaRepository <Empresa, Long> {
}
