package br.com.dbc.vemser.pessoaapi.createDto;

import br.com.dbc.vemser.pessoaapi.entity.TipoPet;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PetCreateDTO {
    private TipoPet idPet;
    private TipoPet idPessoa;
    @NotBlank
    @NotNull
    private String Nome;
    @NotBlank
    @NotNull
    private TipoPet tipoPet;
}
