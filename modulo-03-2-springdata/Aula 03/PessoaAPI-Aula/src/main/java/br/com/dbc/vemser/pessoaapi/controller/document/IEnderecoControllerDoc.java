package br.com.dbc.vemser.pessoaapi.controller.document;
import br.com.dbc.vemser.pessoaapi.dto.EnderecoDTO;
import br.com.dbc.vemser.pessoaapi.createDto.EnderecoCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.GenericResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
public interface IEnderecoControllerDoc {
    @Operation(summary = "Listar endereços", description = "Lista todos os endereços do banco")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna a lista de endereços"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @GetMapping
    ResponseEntity<List<EnderecoCreateDTO>> enderecos();


    @Operation(summary = "Listar endereços pelo id", description = "Lista o endereço com id correspondente no banco")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna um endereço"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @GetMapping("/{id-endereco}") // GET localhost:8080/endereco
     ResponseEntity<Object> enderecoById(@PathVariable("id-endereco") Integer idEndereco);


//    @Operation(summary = "Listar endereços de determinada pessoa", description = "Lista todos os endereços de uma pessoa no banco")
//    @ApiResponses(
//            value = {
//                    @ApiResponse(responseCode = "200", description = "Retorna a lista de endereços de uma pessoa no banco"),
//                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
//                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
//            }
//    )
//    @GetMapping("/bypessoa/{id-pessoa}") // GET localhost:8080/endereco/bypessoa/{id-pessoa}
//     ResponseEntity<List<EnderecoDTO>> listByPessoa(@PathVariable("id-pessoa") Integer id);



    @Operation(summary = "Cria um endereço", description = "Cria um endereço no banco")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Cria um novo endereço"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @PostMapping // POST localhost:8080/endereco
     ResponseEntity<EnderecoCreateDTO> create(@Valid @RequestBody EnderecoDTO endereco) throws Exception;



//    @Operation(summary = "Cria endereço para pessoas", description = "Insere um novo endereço de uma pessoa já existente no banco")
//    @ApiResponses(
//            value = {
//                    @ApiResponse(responseCode = "200", description = "Cria um endereço para pessoa"),
//                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
//                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
//            }
//    )
//    @PostMapping("/{idPessoa}") // PUT localhost:8080/endereco/{idPessoa}
//     ResponseEntity<Object> createByPessoa(@PathVariable("idPessoa") Integer id, @RequestBody EnderecoCreateDTO endereco) throws Exception;




    @Operation(summary = "Edita endereços", description = "Edita um endereço do banco")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Edita um endereço"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @PutMapping("/{idEndereco}") // PUT localhost:8080/endereco/{idEndereco}
     ResponseEntity<Object> update(@PathVariable("idEndereco") Integer id, @RequestBody EnderecoDTO enderecoAtualizar) throws Exception;




    @Operation(summary = "Deleta endereços", description = "Deleta um endereço do banco")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Deleta o endereço informado"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @DeleteMapping("/{idEndereco}") // DELETE localhost:8080/endereco/{idEndereco}
     ResponseEntity<GenericResponseDTO> delete(@PathVariable("idEndereco") Integer id) throws Exception;
}
