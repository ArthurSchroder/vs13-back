package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dto.PessoaContatoDTO;
import br.com.dbc.vemser.pessoaapi.dto.PessoaEnderecoDTO;
import br.com.dbc.vemser.pessoaapi.dto.PessoaPetDTO;
import br.com.dbc.vemser.pessoaapi.entity.Pessoa;
import br.com.dbc.vemser.pessoaapi.dto.PessoaDTO;
import br.com.dbc.vemser.pessoaapi.createDto.PessoaCreateDTO;
import br.com.dbc.vemser.pessoaapi.repository.PessoaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Slf4j
@AllArgsConstructor
public class PessoaService {


    private PessoaRepository pessoaRepository;
    private ObjectMapper objectMapper;

    public PessoaCreateDTO create(PessoaDTO pessoaDTO) throws Exception {
        log.debug("Criando pessoa ");

        // Validacoes manuais

        Pessoa pessoaEntity = objectMapper.convertValue(pessoaDTO, Pessoa.class);

        pessoaEntity = pessoaRepository.save(pessoaEntity);

        PessoaCreateDTO pessoaCreateDTO = objectMapper.convertValue(pessoaEntity, PessoaCreateDTO.class);

        return pessoaCreateDTO;
    }

    public List<PessoaCreateDTO> list(){
        return pessoaRepository.findAll().stream()
                .map(pessoa -> objectMapper.convertValue(pessoa, PessoaCreateDTO.class))
                .toList();
    }

    public List<PessoaCreateDTO> listAll(){
        return pessoaRepository.findAll().stream()
                .map(pessoa -> objectMapper.convertValue(pessoa, PessoaCreateDTO.class))
                .toList();
    }

    public List<PessoaCreateDTO> listByPessoa (String nome){
        return pessoaRepository.findAllByNomeContainingIgnoreCase(nome).stream()
                .filter(pessoa -> pessoa.getNome().equals(nome))
                .map(pessoa -> objectMapper.convertValue(pessoa, PessoaCreateDTO.class)).collect(Collectors.toList());
    }

    public List<PessoaCreateDTO> listByCpf(String cpf){
        return pessoaRepository.findAllByCpfContainingIgnoreCase(cpf)
                .stream().map(pessoa -> objectMapper.convertValue(pessoa, PessoaCreateDTO.class)).toList();
    }

    public List<PessoaEnderecoDTO> listWithAdress(){
        return pessoaRepository.findAll().stream()
                .map(pessoa -> objectMapper.convertValue(pessoa, PessoaEnderecoDTO.class))
                .toList();
    }

    public List<PessoaCreateDTO> listByBirthday(LocalDate dateStart, LocalDate dateEnd){
        return pessoaRepository.findAllByDataNascimentoIsBetween(dateStart, dateEnd)
                .stream().map(pessoa -> objectMapper.convertValue(pessoa, PessoaCreateDTO.class)).toList();
    }

    public List<PessoaContatoDTO> listWithContacts(){
        return pessoaRepository.findAll().stream()
                .map(pessoa -> objectMapper.convertValue(pessoa, PessoaContatoDTO.class)).toList();
    }

    public List<PessoaPetDTO> listWithPets(){
        return pessoaRepository.findAll().stream()
                .map(pessoa -> objectMapper.convertValue(pessoa, PessoaPetDTO.class)).toList();
    }

    public PessoaCreateDTO update(Integer id, PessoaDTO pessoaAtualizar) throws Exception {
        Pessoa pessoaRecuperada = getPessoa(id);

        pessoaRecuperada.setCpf(pessoaAtualizar.getCpf());
        pessoaRecuperada.setNome(pessoaAtualizar.getNome());
        pessoaRecuperada.setDataNascimento(pessoaAtualizar.getDataNascimento());

        return objectMapper.convertValue(pessoaRecuperada, PessoaCreateDTO.class);
    }

    public void delete(Integer id) throws Exception {
        Pessoa pessoaRecuperada = getPessoa(id);
        pessoaRepository.delete(pessoaRecuperada);
    }

    public List<PessoaDTO> listByName(String nome){
            return pessoaRepository.findAll().stream()
                    .filter(pessoa -> pessoa.getNome().equals(nome))
                    .map(pessoa -> objectMapper.convertValue(pessoa, PessoaDTO.class)).toList();
    }

    public Pessoa getPessoa(Integer idPessoa) throws Exception {
        return pessoaRepository.findById(idPessoa).stream()
                .filter(pessoa -> pessoa.getIdPessoa().equals(idPessoa))
                .findFirst()
                .orElseThrow(() -> new Exception("Id inválido"));
    }
}
