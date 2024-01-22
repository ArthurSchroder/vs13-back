package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.entity.*;
import br.com.dbc.vemser.pessoaapi.repository.EnderecoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Service;

import java.util.List;
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

    public Endereco createByPessoa(Integer idPessoa, Endereco endereco) throws Exception {
        if (ObjectUtils.isEmpty(endereco) ){
            throw new Exception("Endereco inválido!");}
        return enderecoRepository.createByPessoa(idPessoa, endereco);
    }

    public List<Endereco> enderecos(){
        return enderecoRepository.enderecos();
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
        Endereco enderecoRecuperado = getEndereco(id);
        enderecoRepository.delete(enderecoRecuperado);
    }

    public List<Endereco> listByPessoa (Integer id) {
        return enderecoRepository.listByPessoa(id);
    }

    public Endereco getEndereco(Integer id) throws Exception {
        Endereco enderecoRecuperada = enderecoRepository.enderecos().stream()
                .filter(endereco -> endereco.getIdEndereco().equals(id))
                .findFirst()
                .orElseThrow(() -> new Exception("Endereço não encontrada!"));
        return enderecoRecuperada;
    }
}
