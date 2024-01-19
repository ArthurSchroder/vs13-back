package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.controller.dto.ContatoDTO;
import br.com.dbc.vemser.pessoaapi.entity.Contato;
import br.com.dbc.vemser.pessoaapi.entity.Pessoa;
import br.com.dbc.vemser.pessoaapi.entity.TipoContato;
import br.com.dbc.vemser.pessoaapi.repository.ContatoRepository;
import br.com.dbc.vemser.pessoaapi.repository.PessoaRepository;
import org.springframework.expression.ExpressionException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContatoService {
    private final ContatoRepository contatoRepository;
    private final PessoaRepository pessoaRepository;

    public ContatoService(ContatoRepository contatoRepository, PessoaRepository pessoaRepository){
        this.contatoRepository = contatoRepository;
        this.pessoaRepository = pessoaRepository;
    }

    public Contato create(ContatoDTO contato) throws Exception {
        Contato contatoSalvar = new Contato();

        contatoSalvar.setIdPessoa(getPessoa(contato.getIdPessoa()));
        contatoSalvar.setTipoContato(TipoContato.ofTipo(contato.getTipoContato()));
        contatoSalvar.setNumero(contato.getNumero());
        contatoSalvar.setDescricao(contato.getDescricao());
        return contatoRepository.create(contatoSalvar);
    }

    private Integer getPessoa(Integer idPessoa) throws Exception {
        Pessoa pessoaId = pessoaRepository.list().stream()
                .filter(pessoa -> pessoa.getIdPessoa().equals(idPessoa))
                .findFirst()
                .orElseThrow(() -> new Exception("Id de pessoa inválido"));
        return pessoaId.getIdPessoa();
    }

    public List<Contato> getContatos(){
        return contatoRepository.contatos();
    }


    //Integer idContato, Integer idPessoa, TipoContato tipoContato, String numero, String descricao
    public Contato atualizar (Integer id,
                              ContatoDTO contatoAtualizar) throws Exception {
        Contato contatoRecuperada = getContato(id);

        contatoRecuperada.setIdPessoa(getPessoa(contatoAtualizar.getIdPessoa()));
        contatoRecuperada.setTipoContato(TipoContato.ofTipo(contatoAtualizar.getTipoContato()));
        contatoRecuperada.setNumero(contatoAtualizar.getNumero());
        contatoRecuperada.setDescricao(contatoAtualizar.getDescricao());

        return contatoRecuperada;
    }

    public void delete(Integer id) throws Exception {
        Contato contatoRecuperada = getContato(id);
        contatoRepository.delete(contatoRecuperada);
    }

    public List<Contato> listByPessoa(int idPessoa) {
        return contatoRepository.listByPessoa(1);
    }

    private Contato getContato(Integer id) throws Exception {
        Contato contatoRecuperada = contatoRepository.contatos().stream()
                .filter(contato -> contato.getIdContato().equals(id))
                .findFirst()
                .orElseThrow(() -> new Exception("Pessoa não encontrada!"));
        return contatoRecuperada;
    }

    public List<Contato> getContatos(Integer idPessoa) {
        return contatoRepository.contatos().stream()
                .filter(contato -> contato.getIdPessoa() == idPessoa)
                .collect(Collectors.toList());
    }
}
