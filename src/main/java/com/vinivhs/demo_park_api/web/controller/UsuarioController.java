package com.vinivhs.demo_park_api.web.controller;

import com.vinivhs.demo_park_api.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/usuarios")

public class UsuarioController {

    private final UsuarioService usuarioService;


}
