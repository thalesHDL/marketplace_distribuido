package com.sd.marcketplace.model.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.sd.marcketplace.model.domain.Comentario;

@Repository
public interface ComentarioRepositorio extends JpaRepository<Comentario, Long> {
}
