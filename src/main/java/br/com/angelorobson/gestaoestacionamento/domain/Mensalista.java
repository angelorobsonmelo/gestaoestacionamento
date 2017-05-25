package br.com.angelorobson.gestaoestacionamento.domain;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Angelo on 24/05/2017.
 */
@Entity
@DiscriminatorValue(value = "Mensalista")
public class Mensalista extends Usuario {

    private String cnpj;

    @OneToOne(mappedBy = "mensalista", cascade = CascadeType.ALL)
    private VeiculoMensalista veiculoMensalista;

    @ManyToOne
    @JoinColumn(name = "codigo_empresa")
    private Empresa empresa;

    @ManyToOne
    @JoinColumn(name = "codigo_proprietario")
    private Proprietario proprietario;

    public String getCnpj() {
        return cnpj;
    }

    @OneToMany(mappedBy = "mensalista")
    private List<Mensalidade> mensalidade;

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public VeiculoMensalista getVeiculoMensalista() {
        return veiculoMensalista;
    }

    public void setVeiculoMensalista(VeiculoMensalista veiculoMensalista) {
        this.veiculoMensalista = veiculoMensalista;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Proprietario getProprietario() {
        return proprietario;
    }

    public void setProprietario(Proprietario proprietario) {
        this.proprietario = proprietario;
    }
}
