package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.controller.document.IPessoaControllerDoc;
import br.com.dbc.vemser.pessoaapi.createDto.PessoaCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.GenericResponseDTO;
import br.com.dbc.vemser.pessoaapi.dto.PessoaDTO;
import br.com.dbc.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.service.PessoaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/pessoa") // localhost:8080/pessoa
@Slf4j
public class PessoaController implements IPessoaControllerDoc{

    private final PessoaService pessoaService;

    @GetMapping // GET localhost:8080/pessoa
    public ResponseEntity<List<PessoaCreateDTO>> list() {
        return ResponseEntity.ok(pessoaService.list());
    }

    @GetMapping("/byname/{nome}") // GET localhost:8080/pessoa/byname/Fulano
    public ResponseEntity<List<PessoaCreateDTO>> listByName(@PathVariable("nome") String nome) {
        List<PessoaCreateDTO> pessoaByName = pessoaService.listByPessoa(nome);
        log.debug("Busando pessoa por nome");
        return ResponseEntity.ok(pessoaByName);
    }

    @PostMapping // POST localhost:8080/pessoa
    public ResponseEntity<PessoaCreateDTO> create(@Valid @RequestBody PessoaDTO pessoa) throws Exception {
        log.debug("Criando pessoa");

        PessoaCreateDTO pessoaCriada = pessoaService.create(pessoa);
        log.debug("Pessoa criada!");

        return ResponseEntity.ok(pessoaCriada);
    }

    @PutMapping("/{idPessoa}") // PUT localhost:8080/pessoa/1000
    public ResponseEntity<Object> update(@PathVariable("idPessoa") Integer id,
                         @RequestBody PessoaDTO pessoaAtualizar) throws Exception {
        try {
            PessoaCreateDTO pessoaAtualizada = pessoaService.update(id, pessoaAtualizar);
            log.debug("Pessoa atualizada");
            return ResponseEntity.ok(pessoaAtualizada);
        }catch (RegraDeNegocioException e){
            return ResponseEntity.badRequest().body(new GenericResponseDTO(e.getMessage()));
        }
    }

    @DeleteMapping("/{idPessoa}") // DELETE localhost:8080/pessoa/10
    public ResponseEntity<Object> delete(@PathVariable("idPessoa") Integer id) throws Exception {
        try {
            pessoaService.delete(id);
        }catch (RegraDeNegocioException e) {
            return ResponseEntity.badRequest().body(new GenericResponseDTO("Não foi possível excluir a pessoa"));
        }
        log.debug("Pessoa excluída");
        return ResponseEntity.ok(new GenericResponseDTO("Pessoa excluída com sucesso"));
    }
}
