package br.com.angelorobson.gestaoestacionamento.domain;

import javax.persistence.*;
import javax.swing.text.StyledEditorKit;
import java.util.Date;

/**
 * Created by Angelo on 24/05/2017.
 */
@Entity
public class EntradaEhSaidaVeiculoAvulso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date dateEntrada;
    private String horaEntrada;

    @OneToOne
    @JoinColumn(name = "cod_veiculo_avulso")
    private VeiculoAvulso veiculoAvulso;

    private Boolean status;

    private String codigoBilhete;

    private Date dataSaida;
    private String horaSaida;






}
