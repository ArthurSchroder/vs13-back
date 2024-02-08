package br.com.dbc.vemser.pessoaapi.dto;

import br.com.dbc.vemser.pessoaapi.entity.Pet;
import lombok.Data;

import java.util.Set;

@Data
public class PessoaPetDTO extends PessoaDTO {
    private Set<Pet> pet;
}
