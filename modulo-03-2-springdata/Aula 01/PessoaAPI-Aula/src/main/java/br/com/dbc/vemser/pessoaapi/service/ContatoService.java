package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.entity.*;
import br.com.dbc.vemser.pessoaapi.createDto.ContatoCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.ContatoDTO;
import br.com.dbc.vemser.pessoaapi.repository.ContatoRepository;
import br.com.dbc.vemser.pessoaapi.repository.PessoaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j

public class ContatoService {
    private final ContatoRepository contatoRepository;
    private final PessoaRepository pessoaRepository;
    ObjectMapper objectMapper = new ObjectMapper();

    public ContatoDTO create (ContatoCreateDTO contatoCreateDTO) throws Exception {
        log.debug("Criando contato ");


        Contato contatoEntity = objectMapper.convertValue(contatoCreateDTO, Contato.class);

        contatoEntity = contatoRepository.save(contatoEntity);

        ContatoDTO contatoDTO = objectMapper.convertValue(contatoEntity, ContatoDTO.class);

        return contatoDTO;
    }

    private Integer getPessoa(Integer idPessoa) throws Exception {
        Pessoa pessoaId = pessoaRepository.findAll().stream()
                .filter(pessoa -> pessoa.getIdPessoa().equals(idPessoa))
                .findFirst()
                .orElseThrow(() -> new Exception("Id de pessoa inválido"));
        return pessoaId.getIdPessoa();
    }

    public List<ContatoCreateDTO> getContatos(){
        return contatoRepository.findAll().stream()
                .map(contato -> objectMapper.convertValue(contato, ContatoCreateDTO.class))
                .toList();
    }


    //Integer idContato, Integer idPessoa, TipoContato tipoContato, String numero, String descricao
    public ContatoCreateDTO atualizar (Integer id,
                                       ContatoDTO contatoAtualizar) throws Exception {
        ContatoDTO contatoRecuperada = getContato(id);

        contatoRecuperada.setIdPessoa(getPessoa(contatoAtualizar.getIdPessoa()));
        contatoRecuperada.setTipoContato(contatoAtualizar.getTipoContato());
        contatoRecuperada.setNumero(contatoAtualizar.getNumero());
        contatoRecuperada.setDescricao(contatoAtualizar.getDescricao());

        return objectMapper.convertValue(contatoRecuperada, ContatoCreateDTO.class);
    }

    public void delete(Integer id) throws Exception {
        ContatoDTO contatoRecuperada = getContato(id);
        Contato contatoCriado = objectMapper.convertValue(contatoRecuperada, Contato.class);
        contatoRepository.delete(contatoCriado);
    }

    private ContatoDTO getContato(Integer id) throws Exception {
        return contatoRepository.findAll().stream()
                .filter(contato -> contato.getIdContato() == id)
                .map(contato -> objectMapper.convertValue(contato, ContatoDTO.class)).findFirst()
                .orElseThrow(()-> new Exception("Id inválido"));
    }

    public List<ContatoDTO> getContatosByPessoa (Integer idPessoa) {
        return contatoRepository.findAll().stream()
                .filter(contato -> contato.getIdPessoa().equals(idPessoa))
                .map(contato -> objectMapper.convertValue(contato, ContatoDTO.class))
                .toList();
    }
}
