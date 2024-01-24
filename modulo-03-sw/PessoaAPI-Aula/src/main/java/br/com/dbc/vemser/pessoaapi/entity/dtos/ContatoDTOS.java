package br.com.dbc.vemser.pessoaapi.entity.dtos;

import br.com.dbc.vemser.pessoaapi.entity.TipoContato;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.validation.annotation.Validated;

@Validated
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ContatoDTOS{
    private Integer idContato;
    @NotNull
    @NotBlank
    private Integer idPessoa;
    @NonNull
    @NotBlank
    private TipoContato tipoContato;
    @NotBlank
    private String numero;
    @NotBlank
    private String descricao;
}
