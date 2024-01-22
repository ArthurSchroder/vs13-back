package br.com.dbc.vemser.pessoaapi.repository;

import br.com.dbc.vemser.pessoaapi.entity.Contato;
import br.com.dbc.vemser.pessoaapi.entity.TipoContato;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Repository
public class ContatoRepository {
    private static List<Contato> listaContatos = new ArrayList<>();
    private AtomicInteger COUNTER = new AtomicInteger();

    public ContatoRepository() {
        listaContatos.add(new Contato(COUNTER.incrementAndGet(), 1, TipoContato.ofTipo(1), "6135622515", "Telefone 1"));
        listaContatos.add(new Contato(COUNTER.incrementAndGet(), 1, TipoContato.ofTipo(2), "61998754526", "Telefone 2"));
        listaContatos.add(new Contato(COUNTER.incrementAndGet(), 2, TipoContato.ofTipo(1), "6133213030", "Telefone 1"));
    }

    public Contato create(Contato contato) {
        contato.setIdContato(COUNTER.incrementAndGet());
        listaContatos.add(contato);
        return contato;
    }

    public List<Contato> contatos() {
        return listaContatos;
    }

    public void delete(Contato contato) {
        listaContatos.remove(contato);
    }

    public List<Contato> listByPessoa(Integer idPessoa) {
        return listaContatos.stream()
                .filter(contato -> contato.getIdPessoa() == idPessoa)
                .collect(Collectors.toList());
    }
}
