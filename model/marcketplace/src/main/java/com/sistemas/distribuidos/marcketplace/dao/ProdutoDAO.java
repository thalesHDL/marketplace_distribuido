package com.sistemas.distribuidos.marcketplace.dao;


import com.sistemas.distribuidos.marcketplace.domain.Produto;
import com.sistemas.distribuidos.marcketplace.util.MarcketplaceConstantes;
import com.sistemas.distribuidos.marcketplace.util.ProjectUtil;


public class ProdutoDAO extends GenericDAO<Produto> {

	// constructors
	public ProdutoDAO() {
		super.setFilePath(ProjectUtil.getDbFilePath() + this.getClass().getSimpleName() + MarcketplaceConstantes.DB_EXTENSION);
	}
	
}