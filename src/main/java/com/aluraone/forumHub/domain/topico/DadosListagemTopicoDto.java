package com.aluraone.forumHub.domain.topico;

public record DadosListagemTopicoDto(
        Long id,
    String titulo,
    String mensagem
        //,
    //  DadosListagemCursoDto curso
){


    public DadosListagemTopicoDto(Topico topico){
        this(topico.getId(), topico.getTitulo(), topico.getMensagem()
                //, new DadosListagemCursoDto(topico.getCurso())
                );
    }
}


