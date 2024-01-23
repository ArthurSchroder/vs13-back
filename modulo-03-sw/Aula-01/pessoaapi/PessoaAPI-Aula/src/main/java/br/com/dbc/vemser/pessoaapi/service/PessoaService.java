package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.entity.Pessoa;
import br.com.dbc.vemser.pessoaapi.entity.PessoaDTO;
import br.com.dbc.vemser.pessoaapi.entity.PessoaDTOS;
import br.com.dbc.vemser.pessoaapi.repository.PessoaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class PessoaService {


    private PessoaRepository pessoaRepository;
    private ObjectMapper objectMapper;

    public PessoaDTO create(PessoaDTOS pessoaDTOS) throws Exception {
        log.debug("Criando pessoa ");

        // Validacoes manuais

        Pessoa pessoaEntity = objectMapper.convertValue(pessoaDTOS, Pessoa.class);

        pessoaEntity = pessoaRepository.create(pessoaEntity);

        PessoaDTO pessoaDTO = objectMapper.convertValue(pessoaEntity, PessoaDTO.class);

        return pessoaDTO;
    }

    public List<PessoaDTO> list(){
        return pessoaRepository.list().stream()
                .map(pessoa -> objectMapper.convertValue(pessoa, PessoaDTO.class))
                .toList();
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
