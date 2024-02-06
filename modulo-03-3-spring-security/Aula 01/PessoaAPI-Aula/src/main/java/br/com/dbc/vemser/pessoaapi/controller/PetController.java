package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.createDto.PetCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.GenericResponseDTO;
import br.com.dbc.vemser.pessoaapi.dto.PetDTO;
import br.com.dbc.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.service.PetService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/pet") // localhost:8080/pessoa
@Slf4j
public class PetController {
    public final PetService petService;
    ObjectMapper objectMapper;

    @GetMapping
    public ResponseEntity<List<PetCreateDTO>> listAll(){
        return ResponseEntity.ok(petService.listAll());
    }

    @PostMapping()
    public ResponseEntity<PetDTO> create (PetDTO pet){
        PetDTO petCriado = petService.create(objectMapper.convertValue(pet, PetCreateDTO.class));
     return ResponseEntity.ok(petCriado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable("id") Integer id, @RequestBody PetCreateDTO pet) throws Exception{
        try{
            PetCreateDTO petAtt = petService.update(id, pet);
            return ResponseEntity.ok(petAtt);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(new GenericResponseDTO(e.getMessage()));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<GenericResponseDTO> delete(@PathVariable("id") Integer id) throws RegraDeNegocioException{
        try {
            petService.delete(id);
        } catch (Exception e){
            return ResponseEntity.badRequest().body(new GenericResponseDTO("Não foi possível exluir o pet."));
        }
        return ResponseEntity.ok().body(new GenericResponseDTO("Contato Excluído com sucesso"));
    }
}
