package br.com.dbc.vemser.pessoaapi.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.persistence.*;

@Entity(name = "PET")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_pet")
    @SequenceGenerator(name = "seq_pet", sequenceName = "seq_pet", allocationSize = 1)
    @Schema(description = "Id do pet", example = "2")
    @Column(name = "ID_PET")
    private Integer idPet;

    @Column(name = "ID_PESSOA", insertable = false, updatable = false)
    @Schema(description = "Id da pessoa: ", required = true, example = "2")
    private Integer idPessoa;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_PESSOA", referencedColumnName = "ID_PESSOA")
    @Schema(description = "Id do pet", example = "2")
    private Pessoa pessoa;

    @Schema(description = "Nome do Pet", example = "2", required = true)
    @Column(name = "NOME")
    private String nome;

    @Column(name = "TIPO")
    @Schema(description = "Tipo do Pet", example = "1")
    @Enumerated(EnumType.ORDINAL)
    private TipoPet tipoPet;
}
