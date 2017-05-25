package br.com.angelorobson.gestaoestacionamento.domain;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Angelo on 15/05/2017.
 */
@Entity
@DiscriminatorValue(value = "Funcionário")
public class Funcionario extends Usuario {

    private String funcao;

    public String getFuncao() {
        return funcao;
    }


    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    @ManyToOne
    private Empresa empresa;

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
}
