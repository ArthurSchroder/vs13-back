package br.com.dbc.vemser.pessoaapi.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Getter
@Setter
public class ProfessorPk implements Serializable {

    @Column(name = "id_Professor")
    public Integer idProfessor;
    @Column(name = "id_Universidade")
    public Integer idUniversidade;
}
