package com.aluraone.forumHub.domain.curso;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CursoRepository extends JpaRepository<Curso, Long> {
    Optional<Curso> findByIdAndStatusTrue(Long id);
    Page<Curso> findByStatusTrue(Pageable pageable);

}
