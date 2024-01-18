package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.controller.dto.ContatoDTO;
import br.com.dbc.vemser.pessoaapi.entity.Contato;
import br.com.dbc.vemser.pessoaapi.entity.Pessoa;
import br.com.dbc.vemser.pessoaapi.service.ContatoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contato") //localhost:8080/contato
public class ContatoController {
    private final ContatoService contatoService;

    public ContatoController(ContatoService contatoService){
        this.contatoService = contatoService;
    }

    @GetMapping ("/listar")//localhost:8080/contato
    public List<Contato> contatos(){
        return contatoService.getContatos();
    }

    @GetMapping//localhost:8080/contato?idPessoa
    public List<Contato> contatos(@RequestParam("idPessoa") Integer idPessoa){
        return contatoService.getContatos(idPessoa);
    }

    @PostMapping("/adicionar-contato") // POST localhost:8080/contato/adicionar-contato
    public Contato adicionarContato (@RequestBody ContatoDTO contatoInserir) throws Exception {
        return contatoService.create(contatoInserir);
    }

    @PutMapping("/{idContato}") // PUT localhost:8080/pessoa/1000
    public Contato atualizar (@PathVariable("idContato") Integer id,
                         @RequestBody ContatoDTO contatoAtualizar) throws Exception {
        return contatoService.atualizar(id, contatoAtualizar);
    }
    @DeleteMapping//localhost:8080/contato?idPessoa
    public void excluirContato(@RequestParam("idContato")Integer idContato) throws Exception {
        contatoService.delete(idContato);
    }
}