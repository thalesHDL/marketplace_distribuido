package com.sd.marcketplace.model.persistencia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sd.marcketplace.model.persistencia.table.TableComentario;

public interface ComentarioRepository extends JpaRepository<TableComentario, Long> {
	
	@Query(value = "SELECT tc FROM TableComentario tc WHERE tc.anuncio.id = :idAnuncio ")
	public List<TableComentario> getComentariosByIdAnuncio(@Param("idAnuncio") Long idAnuncio);
	
}
