package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.entity.*;
import br.com.dbc.vemser.pessoaapi.repository.ContatoRepository;
import br.com.dbc.vemser.pessoaapi.repository.PessoaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@RequiredArgsConstructor
@Service
@Slf4j

public class ContatoService {
    private final ContatoRepository contatoRepository;
    private final PessoaRepository pessoaRepository;
    ObjectMapper objectMapper = new ObjectMapper();

    public ContatoDTO create (ContatoDTOS contatoDTOS) throws Exception {
        log.debug("Criando contato ");


        Contato contatoEntity = objectMapper.convertValue(contatoDTOS, Contato.class);

        contatoEntity = contatoRepository.create(contatoEntity);

        ContatoDTO contatoDTO = objectMapper.convertValue(contatoEntity, ContatoDTO.class);

        return contatoDTO;
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
