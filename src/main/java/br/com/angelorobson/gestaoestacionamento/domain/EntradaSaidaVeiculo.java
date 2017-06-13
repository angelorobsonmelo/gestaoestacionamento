package br.com.angelorobson.gestaoestacionamento.domain;

import javax.persistence.*;
import javax.swing.text.StyledEditorKit;
import java.util.Date;

/**
 * Created by Angelo on 24/05/2017.
 */
@Entity
public class EntradaSaidaVeiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date dateEntrada;
    private String horaEntrada;

    private String placa;

    private String modelo;

    @ManyToOne
    @JoinColumn(name = "cod_categoria")
    private CategoriaVeiculo categoriaVeiculo;

    private Boolean status;

    private String codigoBilhete;

    private String valor;

    @ManyToOne
    @JoinColumn(name = "cod_empresa")
    private Empresa empresa;

    private Date dataSaida;
    private String horaSaida;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateEntrada() {
        return dateEntrada;
    }

    public void setDateEntrada(Date dateEntrada) {
        this.dateEntrada = dateEntrada;
    }

    public String getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(String horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getCodigoBilhete() {
        return codigoBilhete;
    }

    public void setCodigoBilhete(String codigoBilhete) {
        this.codigoBilhete = codigoBilhete;
    }

    public Date getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(Date dataSaida) {
        this.dataSaida = dataSaida;
    }

    public String getHoraSaida() {
        return horaSaida;
    }

    public void setHoraSaida(String horaSaida) {
        this.horaSaida = horaSaida;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public CategoriaVeiculo getCategoriaVeiculo() {
        return categoriaVeiculo;
    }

    public void setCategoriaVeiculo(CategoriaVeiculo categoriaVeiculo) {
        this.categoriaVeiculo = categoriaVeiculo;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
}
