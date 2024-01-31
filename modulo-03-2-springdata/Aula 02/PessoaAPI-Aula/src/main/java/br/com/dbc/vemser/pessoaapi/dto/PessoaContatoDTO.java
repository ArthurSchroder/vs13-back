package br.com.dbc.vemser.pessoaapi.dto;

import br.com.dbc.vemser.pessoaapi.entity.Contato;
import lombok.Data;

import java.util.Set;

@Data
public class PessoaContatoDTO extends PessoaDTO{
    private Set<Contato> listContatos;
}
