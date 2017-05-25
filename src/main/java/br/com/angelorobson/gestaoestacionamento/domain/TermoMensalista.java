package br.com.angelorobson.gestaoestacionamento.domain;

import javax.persistence.*;

/**
 * Created by Angelo on 24/05/2017.
 */
@Entity
public class TermoMensalista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;

    @ManyToOne
    @JoinColumn(name = "cod_empresa")
    private Empresa empresa;

}
