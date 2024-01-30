package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.entity.*;
import br.com.dbc.vemser.pessoaapi.service.ContatoService;
import br.com.dbc.vemser.pessoaapi.service.EnderecoService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("/contato") //localhost:8080/contato
@Slf4j
public class ContatoController {
    private final ContatoService contatoService;

    public ContatoController(ContatoService contatoService){
        this.contatoService = contatoService;
    }

    @GetMapping()//localhost:8080/contato
    public ResponseEntity<List<ContatoDTO>> contatos(){
        log.debug("Listando contatos");
        return ResponseEntity.ok(contatoService.getContatos());
    }

    @GetMapping("/{idPessoa}")///localhost:8080/contato?idPessoa
    public ResponseEntity<List<ContatoDTO>> contatos(@Valid @PathVariable("idPessoa") Integer idPessoa){
        log.debug("Listando Contatos por pessoa");
        return ResponseEntity.ok(contatoService.getContatosByPessoa(idPessoa));
    }

    @PostMapping // POST localhost:8080/endereco
    public ResponseEntity<ContatoDTO> create(@Valid @RequestBody ContatoDTOS contato) throws Exception {
        log.debug("Criando contato");

        ContatoDTO contatoCriado = contatoService.create (contato);
        log.debug("contato criado!");

        //return ResponseEntity.ok(pessoaService.create(pessoa));
        return new ResponseEntity<>(contatoCriado, HttpStatus.OK);
    }

    @PutMapping("/{idContato}") // PUT localhost:8080/pessoa/1000
    public ContatoDTO atualizar (@PathVariable("idContato") Integer id,
                              @Valid @RequestBody ContatoDTO contatoAtualizar) throws Exception {
        return contatoService.atualizar(id, contatoAtualizar);
    }
    @DeleteMapping//localhost:8080/contato?idPessoa
    public void excluirContato(@RequestParam("idContato")Integer idContato) throws Exception {
        contatoService.delete(idContato);
    }}
