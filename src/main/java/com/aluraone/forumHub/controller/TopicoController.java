package com.aluraone.forumHub.controller;

import com.aluraone.forumHub.topico.DadosTopicoDto;
import com.aluraone.forumHub.topico.DadosListagemTopicoDto;
import com.aluraone.forumHub.topico.MedicoRepository;
import com.aluraone.forumHub.topico.Topico;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("topicos")

public class TopicoController {

    @Autowired
    private MedicoRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosTopicoDto topicoDto){
        repository.save( new Topico(topicoDto));

    }

  /*  @GetMapping
    public Page<DadosListagemTopicoDto> listar(@PageableDefault(size=10, sort = {"titulo"}) Pageable paginacao){
     return repository.findAll(paginacao).map(DadosListagemTopicoDto::new);

    }*/

    @GetMapping
    public List<DadosListagemTopicoDto> listar() {
        return repository.findAll().stream().map(DadosListagemTopicoDto::new).toList();


}}
