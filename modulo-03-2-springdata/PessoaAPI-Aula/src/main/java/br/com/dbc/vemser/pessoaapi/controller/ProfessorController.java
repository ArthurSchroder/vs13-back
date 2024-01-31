package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.entity.ProfessorEntity;
import br.com.dbc.vemser.pessoaapi.entity.dto.ProfessorDTO;
import br.com.dbc.vemser.pessoaapi.service.ProfessorService;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.validation.constraints.Digits;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/professor")
@RequiredArgsConstructor
public class ProfessorController {
    ProfessorService professorService;
    ObjectMapper objectMapper;

    @GetMapping
    public List<ProfessorDTO> list(){
        return professorService.list();
    }

    @PostMapping("/{professor}")
    public ProfessorDTO create(@PathVariable("professor") @RequestBody ProfessorDTO professorDTO){
        ProfessorEntity professorEntity =  objectMapper.convertValue(professorDTO, ProfessorEntity.class);
        professorService.create(professorDTO);
        return objectMapper.convertValue(professorEntity, ProfessorDTO.class);
    }

    @PutMapping("/{professor}")
    public ProfessorDTO update(@PathVariable("professor") Integer id, @RequestBody ProfessorDTO professorDTO){
        return professorService.update(id, professorDTO);
    }

    @DeleteMapping("{professor}")
    public void delete(@PathVariable("professor") Integer id){
        professorService.delete(id);
    }
}
