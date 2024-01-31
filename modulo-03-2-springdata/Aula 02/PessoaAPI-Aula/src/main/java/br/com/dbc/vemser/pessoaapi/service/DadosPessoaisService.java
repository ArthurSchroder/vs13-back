package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.client.DadosPessoaisClient;
import br.com.dbc.vemser.pessoaapi.dto.DadosPessoaisDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class DadosPessoaisService {

    public final DadosPessoaisClient dadosPessoaisClient;

    public DadosPessoaisDTO post(DadosPessoaisDTO dadosPessoaisDTO){
        return dadosPessoaisClient.post(dadosPessoaisDTO);
    }

    public List<DadosPessoaisDTO> getAll(){
        return dadosPessoaisClient.getAll();
    }

    public DadosPessoaisDTO getByCpf(String cpf){
        return dadosPessoaisClient.get(cpf);
    }

    public  DadosPessoaisDTO put(String cpf, DadosPessoaisDTO dadosPessoaisDTO){
        return dadosPessoaisClient.put(cpf, dadosPessoaisDTO);
    }

    public void delete(String cpf){
        dadosPessoaisClient.delete(cpf);
    }
}
