package com.sd.marcketplace.model.persistencia.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sd.marcketplace.model.persistencia.table.TableUsuario;

@Repository
public interface UsuarioRepository extends CrudRepository<TableUsuario, Long>{
}
