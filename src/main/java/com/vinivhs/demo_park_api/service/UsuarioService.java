package com.vinivhs.demo_park_api.service;

import com.vinivhs.demo_park_api.entity.Usuario;
import com.vinivhs.demo_park_api.repository.UsuarioRepository;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    @Transactional
    public Usuario salvar(Usuario usuario) {

        return usuarioRepository.save(usuario);
    }

    @Transactional(readOnly  = true)
    public Usuario buscarPorId(long id) {
        return usuarioRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Usuário não encontrado")
        );
    }

    @Transactional
    public Usuario editarSenha(long id, String password) {
        Usuario user = buscarPorId(id);
        user.setPassword(password);
        return user;
    }
    @Transactional(readOnly = true)
    public List<Usuario> buscarTodos() {
        return usuarioRepository.findAll();
    }
}
