package com.vinivhs.demo_park_api.web.dto;

import lombok.*;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor @ToString
public class UsuarioSenhaDto {
    private String senhaAtual;
    private String novaSenha;
    private String confirmaSenha;

}
