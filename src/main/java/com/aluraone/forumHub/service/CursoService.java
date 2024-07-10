package com.aluraone.forumHub.service;

import com.aluraone.forumHub.domain.curso.Curso;
import com.aluraone.forumHub.domain.curso.CursoRepository;
import com.aluraone.forumHub.domain.curso.DadosCursoDto;
import com.aluraone.forumHub.domain.curso.DadosListagemCursoDto;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CursoService {

    @Autowired
    private CursoRepository repository;


    @Transactional
    public Long cadastrarCurso(DadosCursoDto cursoDto) {
        // Validando os campos do Dto
        if (cursoDto.nome() == null ) {
            throw new IllegalArgumentException("O campo Nome é obrigatorio para cadastrar um curso");
        }

        // Criando a entidade desde o DTO
        Curso curso = new Curso();
        curso.setNome(cursoDto.nome());


        // chamando o repository para salvar o curso
        Curso cursoSalvado = repository.save(curso);
        return cursoSalvado.getId();
    }

    public Page<DadosListagemCursoDto> listarCursos(Pageable pageable) {
        Page<Curso> page = repository.findByStatusTrue(pageable);
        return page.map(c -> new DadosListagemCursoDto(
                c.getId(), c.getNome(), c.isStatus()));
    }

    @Transactional
    public DadosListagemCursoDto atualizarCurso(Long idCurso, DadosCursoDto cursoDto) {
System.out.println("llego al service, id para act: " + idCurso);
        Optional<Curso> optional = repository.findById(idCurso);
        if (optional.isEmpty()) {
            throw new IllegalStateException("Não existe Curso com Id: " + idCurso);
        }
        Curso curso = optional.get();
        curso.setNome(cursoDto.nome());
        Curso cursoAct =repository.save(curso);
        return new DadosListagemCursoDto(cursoAct);
    }

    //mostrar detalhes de um curso
    public Optional<DadosListagemCursoDto> detalharCurso(Long idCurso) {

        Optional<Curso> optionalCurso = repository.findByIdAndStatusTrue(idCurso);
          return optionalCurso.map(optC -> new DadosListagemCursoDto(optC.getId(), optC.getNome(), optC.isStatus()));
    }


    //eliminação logica
    @Transactional
    public void inativarCurso(Long idCurso) {
        Optional<Curso> optional = repository.findById(idCurso);
        if (optional.isEmpty()) {
            throw new IllegalStateException("Não existe Curso com Id: " + idCurso);
        }

        /*
          Curso curso = repository.findById(idCurso)
                .orElseThrow(() -> new IllegalStateException("Não existe Curso com Id: " + idCurso));
          */
        Curso curso = optional.get();
        curso.setStatus(false);
        repository.save(curso);
    }



    public boolean existsById(Long cursoId) {
        return repository.existsById(cursoId);
    }
}
