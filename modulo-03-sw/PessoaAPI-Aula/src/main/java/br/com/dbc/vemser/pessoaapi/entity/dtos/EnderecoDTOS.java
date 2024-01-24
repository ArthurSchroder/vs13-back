package br.com.dbc.vemser.pessoaapi.entity.dtos;

import br.com.dbc.vemser.pessoaapi.entity.TipoEndereco;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

@Validated
@AllArgsConstructor
@NoArgsConstructor
@Data
public class EnderecoDTOS {
    private Integer idEndereco;
    @NotBlank
    @NotNull
    private Integer idPessoa;
    @NotBlank
    @NotNull
    private TipoEndereco tipo;
    @NotBlank
    @NotNull
    private String logradouro;
    @NotBlank
    @NotNull
    private Integer numero;
    @NotBlank
    @NotNull
    private String complemento;
    @NotBlank
    @NotNull
    private String cep;
    @NotBlank
    @NotNull
    private String cidade;
    @NotBlank
    @NotNull
    private String estado;
    @NotBlank
    @NotNull
    private String pais;
}
