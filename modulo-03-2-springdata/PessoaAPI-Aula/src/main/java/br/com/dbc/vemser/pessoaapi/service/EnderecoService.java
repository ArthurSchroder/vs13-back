package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.createDto.EnderecoCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.EnderecoDTO;
import br.com.dbc.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.entity.*;
import br.com.dbc.vemser.pessoaapi.repository.EnderecoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Slf4j
public class EnderecoService {

    private final EnderecoRepository enderecoRepository;
    private final EmailService emailService;
    private final PessoaService pessoaService;
    ObjectMapper objectMapper = new ObjectMapper();

    public EnderecoCreateDTO create(EnderecoDTO enderecoDTO) throws Exception {
        log.debug("Criando endereco ");


        Endereco enderecoEntity = objectMapper.convertValue(enderecoDTO, Endereco.class);

        enderecoEntity = enderecoRepository.save(enderecoEntity);

        EnderecoCreateDTO enderecoCriado = objectMapper.convertValue(enderecoEntity, EnderecoCreateDTO.class);



        return enderecoCriado;
    }

//    public EnderecoCreateDTO createByPessoa(Integer idPessoa, @NotBlank EnderecoCreateDTO enderecoCreateDTO) throws Exception {
//        Endereco enderecoEntity = objectMapper.convertValue(enderecoCreateDTO, Endereco.class);
//
//        enderecoEntity = enderecoRepository.createByPessoa(idPessoa, enderecoEntity);
//
//        EnderecoCreateDTO endereco = objectMapper.convertValue(enderecoEntity, EnderecoCreateDTO.class);
//
//        Pessoa pessoa = pessoaService.getPessoa(enderecoEntity.getIdPessoa());
//        String corpo = "Seu endereço foi criado: " + enderecoEntity;
//        emailService.sendEmail("Endereço criado",corpo , pessoa.getNome());
//
//        return endereco;
//    }

    public List<EnderecoCreateDTO> listarTodosEnderecos(){
        return enderecoRepository.findAll().stream()
                .map(endereco -> objectMapper.convertValue(endereco, EnderecoCreateDTO.class))
                .toList();
    }

    public EnderecoCreateDTO update(Integer id, EnderecoDTO enderecoAtualizar) throws Exception {

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

        Pessoa pessoa = pessoaService.getPessoa(enderecoRecuperado.getIdPessoa());
        String corpo = "Seu endereço foi atualizado: " + enderecoRecuperado;
        emailService.sendEmail("Endereço atualizado",corpo , pessoa.getNome());

        return objectMapper.convertValue(enderecoRecuperado, EnderecoCreateDTO.class);
    }

    public void delete(Integer id) throws Exception {
        Endereco endereco = getEndereco(id);
        enderecoRepository.delete(endereco);
        Pessoa pessoa = pessoaService.getPessoa(endereco.getIdPessoa());
        emailService.sendEmail("Endereço deletado", "Seu endereço foi deletado", pessoa.getNome());
    }

//    public List<EnderecoDTO> listByPessoa (Integer id){
//        return enderecoRepository.listByPessoa(id).stream()
//                .filter(endereco -> endereco.getIdPessoa().equals(id))
//                .map(endereco -> objectMapper.convertValue(endereco, EnderecoDTO.class)).collect(Collectors.toList());
//    }

    public EnderecoCreateDTO getEnderecoById(Integer id) throws RegraDeNegocioException {
        return objectMapper.convertValue(getEndereco(id), EnderecoCreateDTO.class);
    }

    public Endereco getEndereco(Integer id) throws RegraDeNegocioException {
        return enderecoRepository.findAll().stream()
                .filter(endereco -> endereco.getIdEndereco().equals(id))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Id inválido"));
    }
    }