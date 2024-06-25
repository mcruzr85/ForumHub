package com.aluraone.forumHub.topico;

import jakarta.validation.constraints.NotBlank;

public record DadosListagemTopicoDto(
        Long id,
    String titulo,

    String mensagem){

    public DadosListagemTopicoDto(Topico topico){
        this(topico.getId(), topico.getMensagem(), topico.getTitulo());

    }



}
