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

    @OneToOne
    @JoinColumn(name = "cod_categoria_preco")
    private CategoriaPreco categoriaPreco;

    private Double valor;

    private Integer percentualDesconto;

    private Boolean status;

    private Date dataPagamento;

    private Integer quantidadeMes;

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

    public CategoriaPreco getCategoriaPreco() {
        return categoriaPreco;
    }

    public void setCategoriaPreco(CategoriaPreco categoriaPreco) {
        this.categoriaPreco = categoriaPreco;
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

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public Integer getQuantidadeMes() {
        return quantidadeMes;
    }

    public void setQuantidadeMes(Integer quantidadeMes) {
        this.quantidadeMes = quantidadeMes;
    }

    public Mensalista getMensalista() {
        return mensalista;
    }

    public void setMensalista(Mensalista mensalista) {
        this.mensalista = mensalista;
    }
}
