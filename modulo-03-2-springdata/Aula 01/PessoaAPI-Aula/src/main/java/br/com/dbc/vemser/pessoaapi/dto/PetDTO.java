package br.com.dbc.vemser.pessoaapi.dto;

import br.com.dbc.vemser.pessoaapi.entity.TipoPet;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import javax.persistence.EmbeddedId;

public class PetDTO {

    private TipoPet idPet;
    private TipoPet idPessoa;
    @NotBlank
    @NotNull
    private String Nome;
    @NotBlank
    @NotNull
    private TipoPet tipoPet;
}
