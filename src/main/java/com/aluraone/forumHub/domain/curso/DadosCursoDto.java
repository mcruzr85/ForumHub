package com.aluraone.forumHub.domain.curso;

import jakarta.validation.constraints.NotBlank;

public record DadosCursoDto(@NotBlank String nome) {
}
