package com.sd.marcketplace.model.persistencia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sd.marcketplace.model.persistencia.table.TableAnuncio;

public interface AnuncioRepository extends JpaRepository<TableAnuncio, Long>{

}
