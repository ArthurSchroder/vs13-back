package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.controller.document.IEnderecoControllerDoc;
import br.com.dbc.vemser.pessoaapi.createDto.EnderecoCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.EnderecoDTO;
import br.com.dbc.vemser.pessoaapi.dto.GenericResponseDTO;
import br.com.dbc.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.service.EnderecoService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/endereco")
public class EnderecoController implements IEnderecoControllerDoc {
    private final EnderecoService enderecoService;

    @GetMapping // GET localhost:8080/endereco
    public ResponseEntity<List<EnderecoCreateDTO>> enderecos() {
        return ResponseEntity.ok(enderecoService.listarTodosEnderecos());
    }

    @GetMapping("/{id-endereco}") // GET localhost:8080/endereco
    public ResponseEntity<Object> enderecoById(@PathVariable("id-endereco") Integer idEndereco) {
        try {
            EnderecoCreateDTO enderecoById = enderecoService.getEnderecoById(idEndereco);
            log.debug("Endereço recuperado");
            return ResponseEntity.ok(enderecoById);
        }catch (RegraDeNegocioException e){
            return ResponseEntity.badRequest().body(new GenericResponseDTO(e.getMessage()));
        }
    }

    @GetMapping("/bypessoa/{id-pessoa}") // GET localhost:8080/endereco/bypessoa/{id-pessoa}
    public ResponseEntity<List<EnderecoDTO>> listByPessoa(@PathVariable("id-pessoa") Integer id) {
        List<EnderecoDTO> enderecoByIdPessoa = enderecoService.listByPessoa(id);
        log.debug("Endereços por pesssoa recuperados");
        return ResponseEntity.ok(enderecoByIdPessoa);
    }

    @PostMapping // POST localhost:8080/endereco
    public ResponseEntity<EnderecoCreateDTO> create(@Valid @RequestBody EnderecoDTO endereco) throws Exception {
        log.debug("Criando endereço");
    
        EnderecoCreateDTO enderecoCriado = enderecoService.create(endereco);
        log.debug("Endereço criado!");

        return new ResponseEntity<>(enderecoCriado, HttpStatus.OK);
    }

    @PostMapping("/{idPessoa}") // PUT localhost:8080/endereco/{idPessoa}
    public ResponseEntity<Object> createByPessoa(@PathVariable("idPessoa") Integer id,
                                                 @RequestBody EnderecoCreateDTO endereco) throws Exception {
        try {
            EnderecoCreateDTO createByPessoa = enderecoService.createByPessoa(id, endereco);
            log.debug("Endereços por pesssoa recuperados");
            return ResponseEntity.ok(createByPessoa);
        }catch (RegraDeNegocioException e){
            return ResponseEntity.badRequest().body(new GenericResponseDTO(e.getMessage()));
        }
    }

    @PutMapping("/{idEndereco}") // PUT localhost:8080/endereco/{idEndereco}
    public ResponseEntity<Object> update(@PathVariable("idEndereco") Integer id,
                                         @RequestBody EnderecoDTO enderecoAtualizar) throws Exception {
        try {
            EnderecoCreateDTO enderecoAtualizado = enderecoService.update(id, enderecoAtualizar);
            log.debug("Endereço atualizado");
            return ResponseEntity.ok(enderecoAtualizado);
        }catch (RegraDeNegocioException e){
            return ResponseEntity.badRequest().body(new GenericResponseDTO(e.getMessage()));
        }
    }

    @DeleteMapping("/{idEndereco}") // DELETE localhost:8080/endereco/{idEndereco}
    public ResponseEntity<GenericResponseDTO> delete(@PathVariable("idEndereco") Integer id) throws Exception {
        try {
            enderecoService.delete(id);
        }catch (RegraDeNegocioException e) {
            return ResponseEntity.badRequest().body(new GenericResponseDTO("Não foi possível excluir o endereço"));
        }
        log.debug("Endereço excluído");
        return ResponseEntity.ok(new GenericResponseDTO("Endereço excluído com sucesso"));
    }
}
