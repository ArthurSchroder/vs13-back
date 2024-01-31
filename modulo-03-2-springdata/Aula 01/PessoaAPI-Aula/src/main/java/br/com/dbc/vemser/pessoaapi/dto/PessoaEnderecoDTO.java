package br.com.dbc.vemser.pessoaapi.dto;

import br.com.dbc.vemser.pessoaapi.entity.Endereco;
import lombok.Data;

import java.util.Set;


@Data
public class PessoaEnderecoDTO extends PessoaDTO{
    private Set<Endereco> enderecos;
}
