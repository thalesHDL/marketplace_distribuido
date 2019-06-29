package com.sd.marcketplace.model.persistencia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sd.marcketplace.model.persistencia.table.TableAnuncio;
import org.springframework.data.repository.query.Param;

public interface AnuncioRepository extends JpaRepository<TableAnuncio, Long>{
	@Query(value = "SELECT * FROM anuncio WHERE id = ':id' ",nativeQuery=true)
	public List<TableAnuncio> getAnunciosByID( @Param("id") Long id);
	
}
