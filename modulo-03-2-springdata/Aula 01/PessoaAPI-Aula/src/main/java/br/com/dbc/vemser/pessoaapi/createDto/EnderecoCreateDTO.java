package br.com.dbc.vemser.pessoaapi.createDto;

import br.com.dbc.vemser.pessoaapi.entity.TipoEndereco;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

@Validated
@AllArgsConstructor
@NoArgsConstructor
@Data
public class EnderecoCreateDTO {
    private Integer idEndereco;
    @NotBlank(message = "O id da pessoa não pode ser vazio")
    @Schema(description = "Id do responsável pelo endereço", required = true, example = "3")
    @NotNull(message = "O id da pessoa não pode ser nulo")
    private Integer idPessoa;

    @NotBlank(message = "O tipo de endereço não pode ser vazio")
    @Schema(description = "Tipo de endereço a ser cadastrado\n1-Residencial\n2-Comercial", required = true, example = "1")
    @NotNull
    private TipoEndereco tipo;

    @NotBlank(message = "O logradouro não pode ser vazio")
    @Schema(description = "Logradouro do endereço", required = true, example = "Avenida y, Rua x")
    @NotNull
    private String logradouro;

    @NotBlank(message = "O número não pode ser vazio")
    @Schema(description = "Numero da residência", required = true, example = "31")
    @NotNull
    private Integer numero;

    @NotBlank(message = "Complemento não pode ser vazio")
    @Schema(description = "Complemento do endereço", required = true, example = "Bloco z, apto")
    @NotNull
    private String complemento;

    @NotBlank(message = "CEP não pode ser vazio")
    @Pattern(regexp = "\\d+")
    @Size(max = 8, min = 8)
    @Schema(description = "CEP do endereço", required = true, example = "75065031")
    @NotNull
    private String cep;

    @NotBlank(message = "Cidade não pode ser vazia")
    @Schema(description = "Cidade onde se localiza o endereço", required = true, example = "Criciúma")
    @NotNull
    private String cidade;

    @NotBlank(message = "Estado não pode ser vazio")
    @Schema(description = "Estado onde se localiza o endereço", required = true, example = "MG")
    @NotNull
    private String estado;

    @NotBlank(message = "País não pode ser vazio")
    @Schema(description = "País onde se localiza o endereço", required = true, example = "Brasil")
    @NotNull
    private String pais;
}
