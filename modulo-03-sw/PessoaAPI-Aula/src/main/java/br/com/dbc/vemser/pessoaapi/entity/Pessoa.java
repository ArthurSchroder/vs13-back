package br.com.dbc.vemser.pessoaapi.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Validated
@Data
public class Pessoa {
    private Integer idPessoa;
    @Schema(description = "Nome da Pessoa", required = true, example = "Rafael Lazzari")
    @NotBlank(message = "O nome não pode ser vazio")
    @Pattern(regexp = "^[a-zA-Z ]*$")
    private String nome;
    @Past
    @Schema(description = "Data de nascimento da pessoa", required = true, example = "1999-02-26")
    @NotNull(message = "A data não pode ser vazia")
    private LocalDate dataNascimento;
    @NotBlank(message = "O CPF não pode ser vazio")
    @Size(min = 11, max = 11)
    @Schema(description = "CPF da pessoa", required = true, example = "06624789558")
    @Pattern(regexp = "\\d+")
    private String cpf;
    @NotBlank
    @Schema(description = "Email da pessoa", required = true, example = "teste123@dbccompany.com.br")
    private String email;
}
