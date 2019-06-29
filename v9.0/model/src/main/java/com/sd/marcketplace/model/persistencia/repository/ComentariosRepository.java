package com.sd.marcketplace.model.persistencia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sd.marcketplace.model.persistencia.table.TableComentario;

public interface ComentariosRepository extends JpaRepository<TableComentario, Long> {

}
