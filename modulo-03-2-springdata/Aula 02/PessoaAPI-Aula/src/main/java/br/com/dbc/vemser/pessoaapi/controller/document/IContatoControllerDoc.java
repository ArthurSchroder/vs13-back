package br.com.dbc.vemser.pessoaapi.controller.document;
import br.com.dbc.vemser.pessoaapi.dto.ContatoDTO;
import br.com.dbc.vemser.pessoaapi.createDto.ContatoCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.GenericResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface IContatoControllerDoc {
    @Operation(summary = "Listar contatos", description = "Lista todos os contatos do banco")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna a lista de contatos"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @GetMapping
    ResponseEntity<List<ContatoCreateDTO>> contatos();



    @Operation(summary = "Listar contatos de uma pessoa", description = "Lista todos os contatos de uma pessoa do banco")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna a lista de contatos de uma pessoa"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @GetMapping("/{idPessoa}")///localhost:8080/contato/idPessoa
    public ResponseEntity<List<ContatoDTO>> contatos(@Valid @PathVariable("idPessoa") Integer idPessoa);



    @Operation(summary = "Insere contatos", description = "Insere contatos no banco")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Cria contatos"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @PostMapping // POST localhost:8080/endereco
    public ResponseEntity<ContatoDTO> create(@Valid @RequestBody ContatoCreateDTO contato) throws Exception;




    @Operation(summary = "Edita contatos", description = "Edita contatos do banco")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Edita contato da lista de contatos"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @PutMapping("/{idContato}") // PUT localhost:8080/pessoa/1000
    public ResponseEntity<Object> atualizar (@PathVariable("idContato") Integer id, @Valid @RequestBody ContatoDTO contatoAtualizar) throws Exception;




    @Operation(summary = "Deleta contatos", description = "Deleta contatos do banco")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Deleta contato da lista de contatos"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @DeleteMapping("/{idContato}")//localhost:8080/contato/idPessoa
    public ResponseEntity<GenericResponseDTO> excluirContato(@PathVariable("idContato")Integer idContato) throws Exception;
}
