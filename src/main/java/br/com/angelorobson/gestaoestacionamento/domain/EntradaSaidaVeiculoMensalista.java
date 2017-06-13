package br.com.angelorobson.gestaoestacionamento.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Angelo on 30/05/2017.
 */
@Entity
public class EntradaSaidaVeiculoMensalista implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date dateEntrada;
    private String horaEntrada;

    @ManyToOne
    @JoinColumn(name = "codigo_mensalista")
    private Mensalista mensalista;

    private Boolean status;

    private String codigoBilhete;

    @ManyToOne
    @JoinColumn(name = "cod_empresa")
    private Empresa empresa;

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

    public Mensalista getMensalista() {
        return mensalista;
    }

    public void setMensalista(Mensalista mensalista) {
        this.mensalista = mensalista;
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

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
}
