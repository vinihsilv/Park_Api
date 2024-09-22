package com.vinivhs.demo_park_api.web.controller;

import com.vinivhs.demo_park_api.entity.Usuario;
import com.vinivhs.demo_park_api.service.UsuarioService;
import com.vinivhs.demo_park_api.web.dto.UsuarioCreateDto;
import com.vinivhs.demo_park_api.web.dto.UsuarioResponseDto;
import com.vinivhs.demo_park_api.web.dto.UsuarioSenhaDto;
import com.vinivhs.demo_park_api.web.dto.mapper.UsuarioMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/usuarios")

public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<UsuarioResponseDto> create(@RequestBody UsuarioCreateDto createDto){
        Usuario user = usuarioService.salvar(UsuarioMapper.toUsuario(createDto));

        return ResponseEntity.status(HttpStatus.CREATED).body(UsuarioMapper.toDto(user));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponseDto> getById(@PathVariable long id){
        Usuario user = usuarioService.buscarPorId(id);

        return ResponseEntity.ok(UsuarioMapper.toDto(user));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> updatePassword(@PathVariable long id, @RequestBody UsuarioSenhaDto dto){
        Usuario user = usuarioService.editarSenha(id, dto.getSenhaAtual(), dto.getNovaSenha(), dto.getConfirmaSenha());

        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<UsuarioResponseDto>> getAll(){
        List<Usuario> users = usuarioService.buscarTodos();

        return ResponseEntity.ok(UsuarioMapper.toListDto(users));
    }


}
