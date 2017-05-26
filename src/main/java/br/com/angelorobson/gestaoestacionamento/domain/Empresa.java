package br.com.angelorobson.gestaoestacionamento.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Angelo on 15/05/2017.
 */
@Entity
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Campo razão social é obrigatório")
    @Column(name = "razao_social")
    private String razaoSocial;
    private String nomeFantasia;
    private String cnpj;
    private Boolean status;
    @OneToOne(mappedBy = "empresa", cascade = CascadeType.ALL)
    @JsonManagedReference
    private EnderecoEmpresa enderecoEmpresa;

    @OneToMany(mappedBy = "empresa", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<TelefoneEmpresa> telefoneEmpresas;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public EnderecoEmpresa getEnderecoEmpresa() {
        return enderecoEmpresa;
    }

    public void setEnderecoEmpresa(EnderecoEmpresa enderecoEmpresa) {
        this.enderecoEmpresa = enderecoEmpresa;
    }

    public List<TelefoneEmpresa> getTelefoneEmpresas() {
        return telefoneEmpresas;
    }

    public void setTelefoneEmpresas(List<TelefoneEmpresa> telefoneEmpresas) {
        this.telefoneEmpresas = telefoneEmpresas;
    }
}
