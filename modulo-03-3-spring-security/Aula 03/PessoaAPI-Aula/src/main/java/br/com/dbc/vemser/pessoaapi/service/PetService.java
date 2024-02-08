package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.createDto.PetCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.PetDTO;
import br.com.dbc.vemser.pessoaapi.entity.Pet;
import br.com.dbc.vemser.pessoaapi.repository.PetRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetService {

    PetRepository petRepository;
    ObjectMapper objectMapper;

    public List<PetCreateDTO> listAll(){
        return petRepository.findAll().stream()
                .map(pet -> objectMapper.convertValue(pet, PetCreateDTO.class)).toList();
    }

    public PetDTO create(PetCreateDTO pet){
        Pet petCriado = objectMapper.convertValue(pet, Pet.class);
        petCriado = petRepository.save(petCriado);
        return objectMapper.convertValue(petCriado, PetDTO.class);
    }

    public PetCreateDTO update(Integer id, PetCreateDTO pet){
        Pet petCriado = findById(id);

        petCriado.setNome(pet.getNome());
        petCriado.setTipoPet(pet.getTipoPet());

        return objectMapper.convertValue(petCriado, PetCreateDTO.class);
    }

    public void delete(Integer id){
        Pet pet = findById(id);
        petRepository.delete(pet);
    }

    public Pet findById(Integer id){
        return petRepository.getById(id);
    }
}
