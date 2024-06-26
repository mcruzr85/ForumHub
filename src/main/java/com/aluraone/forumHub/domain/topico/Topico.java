package com.aluraone.forumHub.domain.topico;

import com.aluraone.forumHub.domain.curso.Curso;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;


import java.time.LocalDateTime;

@Entity(name="topicos")
@Table(name="topicos")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensagem;

    @Column(name="data_criacao")
    private LocalDateTime dataCriacao;

    private boolean status;

    @ManyToOne
    @JoinColumn(name="id_curso")//nome da coluna na tabela
    private Curso curso;


    public Topico(DadosTopicoDto topicoDto){

        this.titulo = topicoDto.titulo();
        this.mensagem = topicoDto.mensagem();
        this.status = true;
        System.out.println(LocalDateTime.now());
        this.dataCriacao = LocalDateTime.now();
        this.setCurso(new Curso(topicoDto.curso().id(), topicoDto.curso().nome()));

    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public void inactivarTopico(){
        this.status = false;
    }
}
