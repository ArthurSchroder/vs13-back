package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dto.ProfessorDTO;
import br.com.dbc.vemser.pessoaapi.dto.UsuarioDTO;
import br.com.dbc.vemser.pessoaapi.createDto.UsuarioCreateDTO;
import br.com.dbc.vemser.pessoaapi.entity.ProfessorEntity;
import br.com.dbc.vemser.pessoaapi.entity.Usuario;
import br.com.dbc.vemser.pessoaapi.repository.UsuarioRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;
    ObjectMapper objectMapper;
    private final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
    public Optional<Usuario> findByLoginAndSenha(String login, String senha) {
        return usuarioRepository.findByLoginAndSenha(login, senha);
    }

    public Optional<Usuario> findById(Integer idUsuario) {
        return usuarioRepository.findById(idUsuario);
    }

    public Optional<Usuario> findByLogin(String login){
        return usuarioRepository.findByLogin(login);
    }

    public Usuario usuarioLogado(){
        return findById(getIdLoggedUser()).orElseThrow(() -> new UsernameNotFoundException("Usuário Inválido"));
    }

    public Integer getIdLoggedUser() {
        return Integer.parseInt(SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString());
    }

    public UsuarioDTO create(UsuarioCreateDTO usuarioDTO){
        Usuario usuarioCriado = objectMapper.convertValue(usuarioDTO, Usuario.class);
        usuarioCriado.setSenha(bCryptPasswordEncoder.encode(usuarioDTO.getSenha()));
        return objectMapper.convertValue(usuarioRepository.save(usuarioCriado), UsuarioDTO.class);
    }



}
