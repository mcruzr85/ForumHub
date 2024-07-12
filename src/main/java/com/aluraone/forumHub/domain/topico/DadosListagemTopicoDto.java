package com.aluraone.forumHub.domain.topico;

import com.aluraone.forumHub.domain.curso.DadosListagemCursoDto;

import java.time.LocalDateTime;

public record DadosListagemTopicoDto(
        Long id,
    String titulo,
    String mensagem,
       LocalDateTime dataCriacao,
    boolean status,
     DadosListagemCursoDto curso
){


    public DadosListagemTopicoDto(Topico topico){
        this(topico.getId(), topico.getTitulo(), topico.getMensagem(), topico.getDataCriacao(), topico.isStatus(),
                 new DadosListagemCursoDto(topico.getCurso())
                );
    }
}


