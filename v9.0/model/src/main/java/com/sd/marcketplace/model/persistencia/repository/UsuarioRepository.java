package com.sd.marcketplace.model.persistencia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sd.marcketplace.model.persistencia.table.TableUsuario;

@Repository
public interface UsuarioRepository extends JpaRepository<TableUsuario, Long> {
}
