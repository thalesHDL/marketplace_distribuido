package com.sd.marcketplace.model.persistencia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sd.marcketplace.model.persistencia.table.TableVenda;

@Repository
public interface VendaRepository extends JpaRepository<TableVenda, Long> {
}
