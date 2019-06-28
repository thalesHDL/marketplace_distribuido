package com.sd.marcketplace.model.persistencia.repository;

import org.springframework.stereotype.Repository;

import com.sd.marcketplace.model.persistencia.table.TableProduto;

@Repository
public class ProdutoRepository extends CustomRepository<TableProduto, Long> {
}
