package com.sd.marcketplace.model.persistencia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sd.marcketplace.model.persistencia.table.TableProduto;

@Repository
public interface ProdutoRepository extends JpaRepository<TableProduto, Long> {
	
	@Query(value = " SELECT tp FROM TableProduto tp WHERE tp.nome = :nome ")
	public TableProduto getByNome(@Param("nome") String nome);
	
}
