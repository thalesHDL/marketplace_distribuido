package com.sd.marcketplace.model.persistencia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sd.marcketplace.model.persistencia.table.TableAnuncio;
import org.springframework.data.repository.query.Param;

public interface AnuncioRepository extends JpaRepository<TableAnuncio, Long>{
	
	@Query(value = " SELECT ta FROM TableAnuncio ta WHERE ta.produto.id = :idProduto ")
	public List<TableAnuncio> getAnunciosByIdProduto(@Param("idProduto") Long idProduto);
	
	@Query(value = " SELECT ta FROM TableAnuncio ta WHERE ta.id = :id ")
	public TableAnuncio getById(@Param("id") Long id);
	
}
