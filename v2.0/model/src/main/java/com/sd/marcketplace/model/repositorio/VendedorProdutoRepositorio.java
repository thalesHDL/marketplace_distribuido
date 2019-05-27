package com.sd.marcketplace.model.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.sd.marcketplace.model.domain.VendedorProduto;

@Repository
public interface VendedorProdutoRepositorio extends JpaRepository<VendedorProduto, Long> {
}
