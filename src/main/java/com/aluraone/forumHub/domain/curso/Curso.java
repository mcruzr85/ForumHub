package com.aluraone.forumHub.domain.curso;

import com.aluraone.forumHub.domain.topico.Topico;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity(name="cursos")
@Table(name="cursos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of ="id")

public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private boolean status;


    @OneToMany(mappedBy = "curso")
    private List<Topico> topicos = new ArrayList<>();


    public Curso(DadosCursoDto dto){
        this.nome = dto.nome();
    }
/*
    public Curso(Long id, String nome){
        this.id = id;
        this.nome = nome;
    }*/


}
