package br.com.dbc.vemser.pessoaapi.entity.pk;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Getter
@Setter
public class PetPk implements Serializable {

    @Column(name = "ID_PET")
    private Integer idPet;

    @Column(name = "ID_PESSOA")
    private Integer idPessoa;
}
