package com.aluraone.forumHub.controller;

import com.aluraone.forumHub.domain.topico.*;
import com.aluraone.forumHub.service.TopicoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/topicos")

public class TopicoController {

    @Autowired
    private TopicoRepository repository;

    @Autowired
    private TopicoService topicoService;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosTopicoDto topicoDto, UriComponentsBuilder uriBuilder,  Authentication authentication){

        String emailUsuarioLoggeado = authentication.getName();
        Long topicoId =  topicoService.cadastrarTopico(topicoDto, emailUsuarioLoggeado);
        var uri = uriBuilder.path("/topicos/{id}").buildAndExpand(topicoId).toUri();
        return ResponseEntity.created(uri).body("Tópico registrado com sucesso. Id: " + topicoId);
    }


    //só os topicos com status = true
    @GetMapping
    public ResponseEntity<Page<DadosListagemTopicoDto>> listar(@PageableDefault(size=10, sort = {"titulo"}) Pageable paginacao){
        var page = repository.findAllByStatusTrue(paginacao).map(DadosListagemTopicoDto::new);
         return ResponseEntity.ok(page);

    }



    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<DadosListagemTopicoDto> atualizar(@PathVariable Long id, @RequestBody @Valid DadosTopicoDto topicoDto ){
        topicoService.atualizarTopico(id, topicoDto);
        return ResponseEntity.ok().body("Tópico atualizado com sucesso. Id: " + topicoId);;
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id){
        topicoService.inativarTopico(id);
        return ResponseEntity.noContent().build();
    }


}
