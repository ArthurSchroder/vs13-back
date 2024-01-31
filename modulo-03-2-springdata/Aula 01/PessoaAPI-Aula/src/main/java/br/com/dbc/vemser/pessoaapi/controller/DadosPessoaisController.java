package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.controller.document.IDadosPessoaisController;
import br.com.dbc.vemser.pessoaapi.dto.DadosPessoaisDTO;
import br.com.dbc.vemser.pessoaapi.dto.GenericResponseDTO;
import br.com.dbc.vemser.pessoaapi.service.DadosPessoaisService;
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
@Slf4j
@RequestMapping("/dados-pessoais")
public class DadosPessoaisController implements IDadosPessoaisController {

    private final DadosPessoaisService dadosPessoaisService;

    @GetMapping()//localhost:8080/dados-pessoais
    public ResponseEntity<List<DadosPessoaisDTO>> getAll(){
        log.debug("Listando Dados Pessoais");
        return ResponseEntity.ok(dadosPessoaisService.getAll());
    }

    @GetMapping("/{cpf}")///localhost:8080/dados-pessoais/00011122233
    public ResponseEntity<DadosPessoaisDTO> getByCpf(@Valid @PathVariable("cpf") String cpf){
        log.debug("Dados por cpf");
        return ResponseEntity.ok(dadosPessoaisService.getByCpf(cpf));
    }

    @PostMapping // POST localhost:8080/dados-pessoais
    public ResponseEntity<DadosPessoaisDTO> create(@Valid @RequestBody DadosPessoaisDTO dadosPessoaisDTO) throws Exception {
        log.debug("Criando nova pessoa");

        DadosPessoaisDTO pessoaCriada = dadosPessoaisService.post (dadosPessoaisDTO);
        log.debug("Pessoa criada!");

        return new ResponseEntity<>(pessoaCriada, HttpStatus.OK);
    }

    @PutMapping("/{cpf}") // PUT localhost:8080/dados-pessoais/00011122233
    public ResponseEntity<Object> atualizar (@PathVariable("cpf") String cpf,
                                             @Valid @RequestBody DadosPessoaisDTO pessoaAtualizar) {
        DadosPessoaisDTO pessoaAtualizada = dadosPessoaisService.put(cpf, pessoaAtualizar);
        log.debug("Pessoa atualizada");
        return ResponseEntity.ok(pessoaAtualizada);

    }
    @DeleteMapping("/{cpf}")//localhost:8080/dados-pessoais/00011122233
    public ResponseEntity<GenericResponseDTO> excluirPessoa (@PathVariable("cpf")String cpf) throws Exception {
        try {
            dadosPessoaisService.delete(cpf);
        }catch (Exception e) {
            return ResponseEntity.badRequest().body(new GenericResponseDTO("Não foi possível excluir a pessoa"));
        }
        log.debug("Pessoa excluída");
        return ResponseEntity.ok(new GenericResponseDTO("Pessoa excluída com sucesso"));
    }
    

}
