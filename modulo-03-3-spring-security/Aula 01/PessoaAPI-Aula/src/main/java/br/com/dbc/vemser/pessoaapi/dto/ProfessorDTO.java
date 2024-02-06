package br.com.dbc.vemser.pessoaapi.dto;

import br.com.dbc.vemser.pessoaapi.entity.pk.ProfessorPk;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ProfessorDTO {
    @NotBlank
    private ProfessorPk professorPk;

    @NotBlank
    private String nome;

    @NotNull
    private Double salario;
}
