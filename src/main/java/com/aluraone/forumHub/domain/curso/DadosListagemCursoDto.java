package com.aluraone.forumHub.domain.curso;

import jakarta.validation.constraints.NotNull;

public record DadosListagemCursoDto(Long id,
                                    String nome) {

    public DadosListagemCursoDto(Curso curso){
        this(curso.getId(), curso.getNome());
    }


}



