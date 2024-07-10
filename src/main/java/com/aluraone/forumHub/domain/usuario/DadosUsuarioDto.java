package com.aluraone.forumHub.domain.usuario;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record DadosUsuarioDto(
        @NotBlank String nome,
        @NotBlank String senha,
        @NotBlank @Email String email
) {
}
