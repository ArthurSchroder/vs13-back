package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.entity.ProfessorEntity;
import br.com.dbc.vemser.pessoaapi.entity.dto.ProfessorDTO;
import br.com.dbc.vemser.pessoaapi.repository.ProfessorRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class ProfessorService {
    private final ProfessorRepository professorRepository;
    private final ObjectMapper objectMapper;

    public List<ProfessorDTO> list(){
        return professorRepository.findAll().stream().map(this::retornarDTO).toList();
    }

    public ProfessorDTO create(ProfessorDTO professorDTO){
        ProfessorEntity professorEntity = professorRepository.save(converterDTO(professorDTO));
        return retornarDTO(professorEntity);
    }

    public ProfessorDTO update(Integer id, ProfessorDTO professorDTO){
        ProfessorEntity professorEntity = findById(id);

        professorEntity.setNome(professorDTO.getNome());
        professorEntity.setSalario(professorDTO.getSalario());
        return retornarDTO(professorRepository.save(professorEntity));
    }

    public void delete(Integer id){
        ProfessorEntity professorEntity = professorRepository.getById(id);
        professorRepository.delete(professorEntity);
    }

    public ProfessorDTO retornarDTO(ProfessorEntity entity){
        return objectMapper.convertValue(entity, ProfessorDTO.class);
    }

    public ProfessorEntity converterDTO (ProfessorDTO professorDTO){
        return objectMapper.convertValue(professorDTO, ProfessorEntity.class);
    }

    public ProfessorEntity findById(Integer id){
        return professorRepository.getById(id);
    }
}
