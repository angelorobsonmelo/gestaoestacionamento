package br.com.angelorobson.gestaoestacionamento.domain;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.Date;
import java.util.List;

/**
 * Created by Angelo on 24/05/2017.
 */
@Entity
public class Mensalidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer diaUtilPagamento;

    private Double valor;

    private Integer percentualDesconto;

    @ManyToOne
    @JoinColumn(name = "cod_usuario_baixa")
    private Usuario usuario;

    @OneToOne
    @JoinColumn(name = "status_mensalidade")
    private StatusMensalidade statusMensalidade;

    private Date dataPagamento;

    private Integer diaPagamento;

    @ManyToOne
    @JoinColumn(name = "cod_mensalista")
    private Mensalista mensalista;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getDiaUtilPagamento() {
        return diaUtilPagamento;
    }

    public void setDiaUtilPagamento(Integer diaUtilPagamento) {
        this.diaUtilPagamento = diaUtilPagamento;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Integer getPercentualDesconto() {
        return percentualDesconto;
    }

    public void setPercentualDesconto(Integer percentualDesconto) {
        this.percentualDesconto = percentualDesconto;
    }


    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public Mensalista getMensalista() {
        return mensalista;
    }

    public void setMensalista(Mensalista mensalista) {
        this.mensalista = mensalista;
    }

    public StatusMensalidade getStatusMensalidade() {
        return statusMensalidade;
    }

    public void setStatusMensalidade(StatusMensalidade statusMensalidade) {
        this.statusMensalidade = statusMensalidade;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Integer getDiaPagamento() {
        return diaPagamento;
    }

    public void setDiaPagamento(Integer diaPagamento) {
        this.diaPagamento = diaPagamento;
    }
}
