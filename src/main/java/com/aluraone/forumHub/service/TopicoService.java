package com.aluraone.forumHub.service;

import com.aluraone.forumHub.domain.curso.Curso;
import com.aluraone.forumHub.domain.curso.CursoRepository;
import com.aluraone.forumHub.domain.topico.DadosCadastroTopicoDto;
import com.aluraone.forumHub.domain.topico.DadosTopicoDto;
import com.aluraone.forumHub.domain.topico.Topico;
import com.aluraone.forumHub.domain.topico.TopicoRepository;
import com.aluraone.forumHub.domain.usuario.Usuario;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class TopicoService {

    @Autowired
    private TopicoRepository topicoRepository;
    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private UsuarioService usuarioService;

    @Transactional
    public Long cadastrarTopico(@RequestBody @Valid DadosTopicoDto dados, String emailUsuarioLoggeado) {

        //usuario loggeado
        Usuario usuarioLoggeado = usuarioService.findByEmail(emailUsuarioLoggeado);

        //curso
       Optional cursoOpt = cursoRepository.findById(dados.curso().id());

        if (cursoOpt.isPresent()) {
            Curso curso = (Curso) cursoOpt.get();
            Topico topico = new Topico(null, dados.titulo(), dados.mensagem(), LocalDateTime.now(), true, curso, usuarioLoggeado);
            Topico topicoSalvado = topicoRepository.save(topico);
            return topicoSalvado.getId();
        }else{
            throw new IllegalArgumentException("O ID do Curso não é válido");
        }
    }


    @Transactional
    public void inativarTopico(Long id){

        Topico topico = topicoRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Tópico não encontrado"));

        //colocando status como falso e assim desativo o topico
        topico.setStatus(false);

        //atualizando o status no banco
       topicoRepository.save(topico);
    }

    @Transactional
    public void atualizarTopico(Long id, DadosTopicoDto dadosTopicoDto){

        Topico topico = topicoRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Tópico não encontrado"));

        //atualizando os dados que vem no Dto
        if(dadosTopicoDto.titulo() != null){
            topico.setTitulo(dadosTopicoDto.titulo());
        }
        if(dadosTopicoDto.mensagem() != null){
            topico.setMensagem(dadosTopicoDto.mensagem());
        }

        //atualizando o topico no banco
        topicoRepository.save(topico);
    }
}
