package com.aluraone.forumHub.topico;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;


import java.time.LocalDate;

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
   // @Enumerated(EnumType.STRING)
   //private Status status;

   // private LocalDate dataCriacao;

    public Topico(DadosTopicoDto topicoDto){
        this.titulo = topicoDto.titulo();
        this.mensagem = topicoDto.mensagem();
        //this.status = "PENDENTE";
        //this.dataCriacao = LocalDate.now();
       // this.status = Status("PENDENTE");
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getMensagem() {
        return mensagem;
    }
}
