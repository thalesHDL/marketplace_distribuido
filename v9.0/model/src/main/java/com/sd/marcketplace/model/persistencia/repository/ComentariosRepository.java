package com.sd.marcketplace.model.persistencia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sd.marcketplace.model.persistencia.table.TableComentario;

public interface ComentariosRepository extends JpaRepository<TableComentario, Long> {
	@Query(value = "SELECT * FROM comentario WHERE id = ':id' ",nativeQuery=true)
	public List<TableComentario> getComentariosByIdAnuncio( @Param("id") Long id);
	
}
