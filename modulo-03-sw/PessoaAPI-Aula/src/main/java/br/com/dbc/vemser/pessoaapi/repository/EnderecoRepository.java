package br.com.dbc.vemser.pessoaapi.repository;

import br.com.dbc.vemser.pessoaapi.entity.Endereco;
import br.com.dbc.vemser.pessoaapi.entity.TipoEndereco;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Repository
public class EnderecoRepository {

    private static List<Endereco> listaEnderecos = new ArrayList<>();
    private AtomicInteger COUNTER = new AtomicInteger();


    //(Integer idPessoa, TipoEndereco tipo, String logradouro, Integer numero, String complemento, String cep, String cidade, String estado, String pais)
    public EnderecoRepository() {
        listaEnderecos.add(new Endereco(COUNTER.incrementAndGet(),1, TipoEndereco.getId(1), "logradouro", 55, "casa", "70032258", "Brasilia", "DF", "Brasil"));
        listaEnderecos.add(new Endereco(COUNTER.incrementAndGet(),1, TipoEndereco.getId(2), "Rua A", 123, "Apto 101", "12345-678", "São Paulo", "SP", "Brasil"));
        listaEnderecos.add(new Endereco(COUNTER.incrementAndGet(),1, TipoEndereco.getId(2), "Rua C", 789,"Casa 303", "98765-432", "Belo Horizonte", "MG", "Brasil"));
        listaEnderecos.add(new Endereco(COUNTER.incrementAndGet(),2, TipoEndereco.getId(1), "Av. B", 456,"Sala 202", "54321-876", "Rio de Janeiro", "RJ", "Brasil"));
    }

    public Endereco create(Endereco endereco) {
        listaEnderecos.add(endereco);
        return endereco;
    }
    public Endereco createByPessoa(Integer idPessoa, Endereco endereco) throws Exception {
        if (ObjectUtils.isEmpty(endereco) ){
            throw new Exception("Endereco inválido!");
        }
        endereco.setIdPessoa(idPessoa);
        listaEnderecos.add(COUNTER.incrementAndGet(), endereco);
        return endereco;
    }
    public List<Endereco> enderecos() {
        return listaEnderecos;
    }

    public void delete(Endereco endereco) {
        listaEnderecos.remove(endereco);
    }

    public List<Endereco> listByPessoa (Integer id) {
        return listaEnderecos.stream()
                .filter(endereco -> endereco.getIdPessoa().toString().equals(id.toString()))
                .collect(Collectors.toList());
    }
}
