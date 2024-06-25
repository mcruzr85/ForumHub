package com.aluraone.forumHub.topico;

import jakarta.validation.constraints.NotBlank;

public record DadosTopicoDto(

        @NotBlank
        String titulo,
        @NotBlank
        String mensagem){}
