package br.com.dbc.vemser.pessoaapi.dto;

import br.com.dbc.vemser.pessoaapi.entity.Cargo;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Set;

public class UsuarioDTO {

    @Schema(description = "idUsuario: ", example = "1")
    private Integer idUsuario;

    @Schema(description = "login: ", example = "arthur", required = true)
    private String login;

    @Schema(description = "senha: ", example = "123", required = true)
    private String senha;

    @Schema(description = "cargos: ", example = "1, 2", required = true)
    private Set<Cargo> cargos;
}
