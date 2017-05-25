package br.com.angelorobson.gestaoestacionamento.domain;

import javax.persistence.*;

/**
 * Created by Angelo on 20/05/2017.
 */
@Entity
@DiscriminatorValue(value = "SuperAdminstrador")
public class SuperAdminstrador extends Usuario {

}
