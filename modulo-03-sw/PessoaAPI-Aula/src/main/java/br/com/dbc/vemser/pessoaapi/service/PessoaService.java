package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.entity.Pessoa;
import br.com.dbc.vemser.pessoaapi.entity.dto.PessoaDTO;
import br.com.dbc.vemser.pessoaapi.entity.dtos.PessoaDTOS;
import br.com.dbc.vemser.pessoaapi.repository.PessoaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@AllArgsConstructor
public class PessoaService {


    private PessoaRepository pessoaRepository;
    private ObjectMapper objectMapper;

    public PessoaDTOS create(PessoaDTO pessoaDTO) throws Exception {
        log.debug("Criando pessoa ");

        // Validacoes manuais

        Pessoa pessoaEntity = objectMapper.convertValue(pessoaDTO, Pessoa.class);

        pessoaEntity = pessoaRepository.create(pessoaEntity);

        PessoaDTOS pessoaDTOS = objectMapper.convertValue(pessoaEntity, PessoaDTOS.class);

        return pessoaDTOS;
    }

    public List<PessoaDTO> list(){
        return pessoaRepository.list().stream()
                .map(pessoa -> objectMapper.convertValue(pessoa, PessoaDTO.class))
                .toList();
    }

    public List<PessoaDTOS> listAll(){
        return pessoaRepository.list().stream()
                .map(pessoa -> objectMapper.convertValue(pessoa, PessoaDTOS.class))
                .toList();
    }

    public List<PessoaDTO> listByPessoa (String nome){
        return pessoaRepository.listByName(nome).stream()
                .filter(pessoa -> pessoa.getNome().equals(nome))
                .map(pessoa -> objectMapper.convertValue(pessoa, PessoaDTO.class)).collect(Collectors.toList());
    }

    public PessoaDTOS update(Integer id, PessoaDTO pessoaAtualizar) throws Exception {
        Pessoa pessoaRecuperada = getPessoa(id);

        pessoaRecuperada.setCpf(pessoaAtualizar.getCpf());
        pessoaRecuperada.setNome(pessoaAtualizar.getNome());
        pessoaRecuperada.setDataNascimento(pessoaAtualizar.getDataNascimento());

        return objectMapper.convertValue(pessoaRecuperada, PessoaDTOS.class);
    }

    public void delete(Integer id) throws Exception {
        Pessoa pessoaRecuperada = getPessoa(id);
        pessoaRepository.delete(pessoaRecuperada);
    }

    public List<PessoaDTO> listByName(String nome){
            return pessoaRepository.listByName(nome).stream()
                    .filter(pessoa -> pessoa.getNome().equals(nome))
                    .map(pessoa -> objectMapper.convertValue(pessoa, PessoaDTO.class)).toList();
    }

    public Pessoa getPessoa(Integer idPessoa) throws Exception {
        return pessoaRepository.list().stream()
                .filter(pessoa -> pessoa.getIdPessoa().equals(idPessoa))
                .findFirst()
                .orElseThrow(() -> new Exception("Id inválido"));
    }
}
