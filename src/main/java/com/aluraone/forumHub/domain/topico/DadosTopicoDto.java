package com.aluraone.forumHub.domain.topico;

import com.aluraone.forumHub.domain.curso.DadosListagemCursoDto;
import jakarta.validation.constraints.NotBlank;

public record DadosTopicoDto(

        @NotBlank
        String titulo,
        @NotBlank
        String mensagem,
        DadosListagemCursoDto curso){}
