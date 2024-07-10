package com.aluraone.forumHub.domain.topico;

import com.aluraone.forumHub.domain.curso.DadosListagemCursoDto;
import jakarta.validation.constraints.NotBlank;

public record DadosCadastroTopicoDto(

        @NotBlank(message = "Campo titulo é obrigatorio")
        String titulo,
        @NotBlank
        String mensagem,
        //UsuarioIdDto autor,
        @NotBlank
        Long idCurso) {
}
