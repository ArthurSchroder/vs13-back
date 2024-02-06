package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.controller.document.IContatoControllerDoc;
import br.com.dbc.vemser.pessoaapi.createDto.ContatoCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.ContatoDTO;
import br.com.dbc.vemser.pessoaapi.dto.GenericResponseDTO;
import br.com.dbc.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.service.ContatoService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@AllArgsConstructor
@RequestMapping("/contato") //localhost:8080/contato
@Slf4j
public class ContatoController implements IContatoControllerDoc {
    private final ContatoService contatoService;

    @GetMapping()//localhost:8080/contato
    public ResponseEntity<List<ContatoCreateDTO>> contatos(){
        log.debug("Listando contatos");
        return ResponseEntity.ok(contatoService.getContatos());
    }

    @GetMapping("/{idPessoa}")///localhost:8080/contato/idPessoa
    public ResponseEntity<List<ContatoDTO>> contatos(@Valid @PathVariable("idPessoa") Integer idPessoa){
        log.debug("Listando Contatos por pessoa");
        return ResponseEntity.ok(contatoService.getContatosByPessoa(idPessoa));
    }

    @PostMapping // POST localhost:8080/endereco
    public ResponseEntity<ContatoDTO> create(@Valid @RequestBody ContatoCreateDTO contato) throws Exception {
        log.debug("Criando contato");

        ContatoDTO contatoCriado = contatoService.create (contato);
        log.debug("contato criado!");

        //return ResponseEntity.ok(pessoaService.create(pessoa));
        return new ResponseEntity<>(contatoCriado, HttpStatus.OK);
    }

    @PutMapping("/{idContato}") // PUT localhost:8080/pessoa/1000
    public ResponseEntity<Object> atualizar (@PathVariable("idContato") Integer id,
                              @Valid @RequestBody ContatoDTO contatoAtualizar) throws Exception {
        try {
            ContatoCreateDTO contatoAtualizado = contatoService.atualizar(id, contatoAtualizar);
            log.debug("Contato atualizado");
            return ResponseEntity.ok(contatoAtualizado);
        }catch (RegraDeNegocioException e){
            return ResponseEntity.badRequest().body(new GenericResponseDTO(e.getMessage()));
        }

    }
    @DeleteMapping("/{idContato}")//localhost:8080/contato/idPessoa
    public ResponseEntity<GenericResponseDTO> excluirContato(@PathVariable("idContato")Integer idContato) throws Exception {
        try {
            contatoService.delete(idContato);
        }catch (RegraDeNegocioException e) {
            return ResponseEntity.badRequest().body(new GenericResponseDTO("Não foi possível excluir o contato"));
        }
        log.debug("Contato excluído");
        return ResponseEntity.ok(new GenericResponseDTO("Contato excluído com sucesso"));
    }
}
