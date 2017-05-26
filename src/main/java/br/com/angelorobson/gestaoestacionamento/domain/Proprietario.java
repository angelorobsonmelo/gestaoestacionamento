package br.com.angelorobson.gestaoestacionamento.domain;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Angelo on 15/05/2017.
 */
@Entity
@DiscriminatorValue(value = "Proprietário")
public class Proprietario extends Usuario {

    @ManyToMany
    private List<Empresa> empresas;

    public List<Empresa> getEmpresas() {
        return empresas;
    }

    public void setEmpresas(List<Empresa> empresas) {
        this.empresas = empresas;
    }
}
