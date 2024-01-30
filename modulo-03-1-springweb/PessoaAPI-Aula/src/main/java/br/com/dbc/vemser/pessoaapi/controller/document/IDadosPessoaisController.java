package br.com.dbc.vemser.pessoaapi.controller.document;

import br.com.dbc.vemser.pessoaapi.dto.DadosPessoaisDTO;
import br.com.dbc.vemser.pessoaapi.dto.GenericResponseDTO;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface IDadosPessoaisController {

    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna a lista de usuários"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @GetMapping()//localhost:8080/dados-pessoais
    public ResponseEntity<List<DadosPessoaisDTO>> getAll();


    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna usuários com CPF informado"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @GetMapping("/{cpf}")///localhost:8080/dados-pessoais/00011122233
    public ResponseEntity<DadosPessoaisDTO> getByCpf(@Valid @PathVariable("cpf") String cpf);



    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Cria usuários"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @PostMapping // POST localhost:8080/dados-pessoais
    public ResponseEntity<DadosPessoaisDTO> create(@Valid @RequestBody DadosPessoaisDTO dadosPessoaisDTO) throws Exception;



    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Edita usuários"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @PutMapping("/{cpf}") // PUT localhost:8080/dados-pessoais/00011122233
    public ResponseEntity<Object> atualizar (@PathVariable("cpf") String cpf,
                                             @Valid @RequestBody DadosPessoaisDTO pessoaAtualizar);


    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Deleta usuários"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @DeleteMapping("/{cpf}")//localhost:8080/dados-pessoais/00011122233
    public ResponseEntity<GenericResponseDTO> excluirPessoa (@PathVariable("cpf")String cpf) throws Exception;
}
