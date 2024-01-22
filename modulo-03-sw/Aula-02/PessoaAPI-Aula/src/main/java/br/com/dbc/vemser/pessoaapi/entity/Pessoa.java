package br.com.dbc.vemser.pessoaapi.entity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
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
    @NotBlank
    private String nome;
    @Past
    @NotNull
    private LocalDate dataNascimento;
    @NotBlank
    private String cpf;
}
