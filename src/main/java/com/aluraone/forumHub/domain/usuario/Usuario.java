package com.aluraone.forumHub.domain.usuario;

import com.aluraone.forumHub.domain.topico.Topico;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;

@Entity(name="usuarios")
@Table(name="usuarios")@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")
public class Usuario {


  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String nome;
  private String email;
  private String senha;
  private boolean status;

  @OneToMany(mappedBy = "autor")
  private List<Topico> topicos = new ArrayList<>();

}
