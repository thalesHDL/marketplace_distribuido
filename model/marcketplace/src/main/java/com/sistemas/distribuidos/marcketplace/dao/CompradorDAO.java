package com.sistemas.distribuidos.marcketplace.dao;


import com.sistemas.distribuidos.marcketplace.domain.Comprador;
import com.sistemas.distribuidos.marcketplace.util.MarcketplaceConstantes;
import com.sistemas.distribuidos.marcketplace.util.ProjectUtil;


public class CompradorDAO extends GenericDAO<Comprador> {

	// constructors
	public CompradorDAO() {
		super.setFilePath(ProjectUtil.getDbFilePath() + this.getClass().getSimpleName() + MarcketplaceConstantes.DB_EXTENSION);
	}

}