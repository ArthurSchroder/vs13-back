package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.entity.*;
import br.com.dbc.vemser.pessoaapi.repository.EnderecoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Slf4j
public class EnderecoService {

    private final EnderecoRepository enderecoRepository;
    ObjectMapper objectMapper = new ObjectMapper();

    public EnderecoDTO create(EnderecoDTOS enderecoDTOS) throws Exception {
        log.debug("Criando endereco ");


        Endereco enderecoEntity = objectMapper.convertValue(enderecoDTOS, Endereco.class);

        enderecoEntity = enderecoRepository.create(enderecoEntity);

        EnderecoDTO enderecoDTO = objectMapper.convertValue(enderecoEntity, EnderecoDTO.class);



        return enderecoDTO;
    }

    public EnderecoDTO createByPessoa(Integer idPessoa,@NotBlank EnderecoDTOS enderecoDTOS) throws Exception {
        Endereco enderecoEntity = objectMapper.convertValue(enderecoDTOS, Endereco.class);

        enderecoEntity = enderecoRepository.createByPessoa(idPessoa, enderecoEntity);

        EnderecoDTO enderecoDTO = objectMapper.convertValue(enderecoEntity, EnderecoDTO.class);

        return enderecoDTO;
    }

    public List<EnderecoDTO> enderecos(){
        return enderecoRepository.enderecos().stream()
                .map(endereco -> objectMapper.convertValue(endereco, EnderecoDTO.class))
                .toList();
    }

    public Endereco update(Integer id, Endereco enderecoAtualizar) throws Exception {
        Endereco enderecoRecuperado = getEndereco(id);

        enderecoRecuperado.setIdPessoa(enderecoAtualizar.getIdPessoa());
        enderecoRecuperado.setTipo(enderecoAtualizar.getTipo());
        enderecoRecuperado.setLogradouro(enderecoAtualizar.getLogradouro());
        enderecoRecuperado.setNumero(enderecoAtualizar.getNumero());
        enderecoRecuperado.setComplemento(enderecoAtualizar.getComplemento());
        enderecoRecuperado.setCep(enderecoAtualizar.getCep());
        enderecoRecuperado.setCidade(enderecoAtualizar.getCidade());
        enderecoRecuperado.setEstado(enderecoAtualizar.getEstado());
        enderecoRecuperado.setPais(enderecoAtualizar.getPais());

        return enderecoRecuperado;
    }

    public void delete(Integer id) throws Exception {
        EnderecoDTO enderecoRecuperado = getEndereco(id);
        objectMapper.convertValue(enderecoRecuperado, Endereco.class);
        enderecoRepository.delete(enderecoRecuperado);
    }

    public List<EnderecoDTO> listByPessoa (Integer id){
        return enderecoRepository.listByPessoa(id).stream()
                .filter(endereco -> endereco.getIdPessoa().equals(id))
                .map(endereco -> objectMapper.convertValue(endereco, EnderecoDTO.class)).collect(Collectors.toList());
    }

    public EnderecoDTO getEndereco(Integer id) throws Exception {
        return enderecoRepository.enderecos().stream()
                .filter(endereco -> endereco.getIdEndereco().equals(id))
                .map(endereco -> objectMapper.convertValue(endereco, EnderecoDTO.class))
                .findFirst()
                .orElseThrow(() -> new Exception("Id inválido"));
    }
    }