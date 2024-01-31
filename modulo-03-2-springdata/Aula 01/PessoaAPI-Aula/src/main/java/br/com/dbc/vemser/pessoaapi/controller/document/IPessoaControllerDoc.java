package br.com.dbc.vemser.pessoaapi.controller.document;

import br.com.dbc.vemser.pessoaapi.dto.PessoaDTO;
import br.com.dbc.vemser.pessoaapi.createDto.PessoaCreateDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

 public interface IPessoaControllerDoc {
    @Operation(summary = "Listar pessoas", description = "Lista todas as pessoas do banco")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna a lista de pessoas"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @GetMapping
    ResponseEntity<List<PessoaCreateDTO>> list();


    @Operation(summary = "Listar pessoas pelo nome", description = "Lista todas as pessoas com o mesmo nome no banco")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna a lista de pessoas pelo nome informado"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @GetMapping("/byname/{nome}")
     ResponseEntity<List<PessoaCreateDTO>> listByName(@PathVariable("nome") String nome);



    @Operation(summary = "Inserir uma pessoa", description = "Insere uma pessoa no banco")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Pessoa foi criada com sucesso"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @PostMapping // POST localhost:8080/pessoa
     ResponseEntity<PessoaCreateDTO> create(@Valid @RequestBody PessoaDTO pessoa) throws Exception;



    @Operation(summary = "Altera pessoas", description = "Altera pessoas do banco")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Edita pessoa da lista de pessoas"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @PutMapping("/{idPessoa}") // PUT localhost:8080/pessoa/1000
     ResponseEntity<Object> update(@PathVariable("idPessoa") Integer id, @RequestBody PessoaDTO pessoaAtualizar) throws Exception;



    @Operation(summary = "Deletar pessoas", description = "Deleta a pessoa informada do banco")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Deleta uma pessoa"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )@DeleteMapping("/{idPessoa}") // DELETE localhost:8080/pessoa/10
     ResponseEntity<Object> delete(@PathVariable("idPessoa") Integer id) throws Exception;
}
