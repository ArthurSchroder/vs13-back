package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.entity.*;
import br.com.dbc.vemser.pessoaapi.repository.ContatoRepository;
import br.com.dbc.vemser.pessoaapi.service.ContatoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Validated
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/contato") //localhost:8080/contato
public class ContatoController {
    ObjectMapper objectMapper = new ObjectMapper();
    private final ContatoService contatoService;
    private final ContatoRepository contatoRepository;

    @GetMapping("/listar")//localhost:8080/contato
    public List<Contato> contatos(){
        return contatoService.getContatos();
    }

    @GetMapping("/{idPessoa}")///localhost:8080/contato?idPessoa
    public List<Contato> contatos(@PathVariable("idPessoa") Integer idPessoa){
        return contatoService.getContatos(idPessoa);
    }

    public ContatoDTO create(ContatoDTOS contatoDTOS) throws Exception {
        log.debug("Criando contato ");


        Contato contatoEntity = objectMapper.convertValue(contatoDTOS, Contato.class);

        contatoEntity = contatoRepository.create(contatoEntity);

        ContatoDTO contatoDTO = objectMapper.convertValue(contatoEntity, ContatoDTO.class);

        return contatoDTO;
    }


    @PutMapping("/{idContato}") // PUT localhost:8080/pessoa/1000
    public Contato atualizar (@PathVariable("idContato") Integer id,
                              @Valid @RequestBody ContatoDTO contatoAtualizar) throws Exception {
        return contatoService.atualizar(id, contatoAtualizar);
    }
    @DeleteMapping//localhost:8080/contato?idPessoa
    public void excluirContato(@RequestParam("idContato")Integer idContato) throws Exception {
        contatoService.delete(idContato);
    }}
