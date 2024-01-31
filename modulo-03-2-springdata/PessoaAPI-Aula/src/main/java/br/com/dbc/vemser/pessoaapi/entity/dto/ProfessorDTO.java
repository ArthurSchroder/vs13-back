package br.com.dbc.vemser.pessoaapi.entity.dto;

import br.com.dbc.vemser.pessoaapi.entity.ProfessorPk;
import br.com.dbc.vemser.pessoaapi.service.ProfessorService;
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
