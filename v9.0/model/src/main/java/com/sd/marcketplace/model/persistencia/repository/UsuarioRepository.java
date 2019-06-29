package com.sd.marcketplace.model.persistencia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sd.marcketplace.model.persistencia.table.TableUsuario;

@Repository
public interface UsuarioRepository extends JpaRepository<TableUsuario, Long> {
	
	@Query(value = " SELECT tu FROM TableUsuario tu WHERE tu.id = :id ")
	public TableUsuario getById(@Param("id") Long id);
	
	@Query(value = " SELECT tu FROM TableUsuario tu WHERE tu.email = :email AND tu.senha = :senha ")
	public TableUsuario getUsuarioByInfoLogin(@Param("email") String email, @Param("senha") String senha);
	
}
