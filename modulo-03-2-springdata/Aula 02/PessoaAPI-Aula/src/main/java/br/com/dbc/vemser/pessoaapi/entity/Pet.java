package br.com.dbc.vemser.pessoaapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pet {
    @EmbeddedId
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_pet")
    @SequenceGenerator(name = "seq_pet", sequenceName = "seq_pet", allocationSize = 1)
    private TipoPet idPet;
    @EmbeddedId
    private TipoPet idPessoa;
    private String Nome;
    private TipoPet tipoPet;
}
