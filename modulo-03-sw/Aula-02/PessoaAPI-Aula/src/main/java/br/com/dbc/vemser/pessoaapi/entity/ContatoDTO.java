package br.com.dbc.vemser.pessoaapi.entity;

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
public class ContatoDTO {

    private Integer idContato;
    @NotNull
    @NotBlank
    private Integer idPessoa;
    @NotNull
    @NotBlank
    private Integer tipoContato;
    @NotBlank
    private String numero;
    @NotBlank
    private String descricao;
}
