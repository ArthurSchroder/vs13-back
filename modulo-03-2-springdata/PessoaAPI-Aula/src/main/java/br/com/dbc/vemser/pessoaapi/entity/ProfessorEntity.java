package br.com.dbc.vemser.pessoaapi.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Getter
@Setter
@Entity (name = "Professor")
public class ProfessorEntity {

    @EmbeddedId
    public ProfessorPk ProfessorPK;
    @Column(name = "nome")
    public String nome;
    @Column (name = "salario")
    public Double salario;
}
