package br.com.angelorobson.gestaoestacionamento.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Angelo on 30/05/2017.
 */
@Entity
public class PrecoCategoriaVeiculoPeriodo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "cod_periodo")
    private Periodo periodo;

    @ManyToOne
    @JoinColumn(name = "cod_categoria_veiculo")
    private CategoriaVeiculo categoriaVeiculo;

    @ManyToOne
    @JoinColumn(name = "cod_empresa")
    private Empresa empresa;

    private Double valor;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Periodo getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Periodo periodo) {
        this.periodo = periodo;
    }

    public CategoriaVeiculo getCategoriaVeiculo() {
        return categoriaVeiculo;
    }

    public void setCategoriaVeiculo(CategoriaVeiculo categoriaVeiculo) {
        this.categoriaVeiculo = categoriaVeiculo;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
}
