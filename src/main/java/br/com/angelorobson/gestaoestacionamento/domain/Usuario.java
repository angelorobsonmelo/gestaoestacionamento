package br.com.angelorobson.gestaoestacionamento.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.*;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import java.util.Date;
import java.util.List;

import static com.fasterxml.jackson.annotation.JsonInclude.Include;
import static javax.persistence.CascadeType.*;

@Entity
@Inheritance (strategy = InheritanceType.SINGLE_TABLE)
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Campo nome é obrigatório")
    private String nome;

    @NotBlank(message = "Campo sobrenome é obrigatório")
    private String sobrenome;

    @NotBlank(message = "Campo cpf é obrigatório")
    private String cpf;

    private Date dataNascimento;

    private Boolean status;

    @NotBlank(message = "Campo login é obrigatório")
    private String login;

    @NotBlank(message = "Campo senha é obrigatório")
    private String senha;

    @NotBlank(message = "Campo email é obrigatório")
    private String email;

    @OneToOne(cascade = ALL, mappedBy = "usuario")
    @JsonManagedReference
    private EnderecoUsuario enderecoUsuario;

    @OneToMany(mappedBy = "usuario", cascade = ALL)
    @JsonManagedReference
    private List<TelefoneUsuario> telefoneUsuarios;

    @ManyToOne
    @JoinColumn(name = "id_perfil_usuario")
    private PerfilUsuario perfilUsuario;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public PerfilUsuario getPerfilUsuario() {
        return perfilUsuario;
    }

    public void setPerfilUsuario(PerfilUsuario perfilUsuario) {
        this.perfilUsuario = perfilUsuario;
    }

    public EnderecoUsuario getEnderecoUsuario() {
        return enderecoUsuario;
    }

    public void setEnderecoUsuario(EnderecoUsuario enderecoUsuario) {
        this.enderecoUsuario = enderecoUsuario;
    }

    public List<TelefoneUsuario> getTelefoneUsuarios() {
        return telefoneUsuarios;
    }

    public void setTelefoneUsuarios(List<TelefoneUsuario> telefoneUsuarios) {
        this.telefoneUsuarios = telefoneUsuarios;
    }
}
