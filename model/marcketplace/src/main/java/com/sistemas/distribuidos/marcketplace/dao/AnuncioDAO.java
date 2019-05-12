package com.sistemas.distribuidos.marcketplace.dao;


import com.sistemas.distribuidos.marcketplace.domain.Anuncio;
import com.sistemas.distribuidos.marcketplace.util.MarcketplaceConstantes;
import com.sistemas.distribuidos.marcketplace.util.ProjectUtil;


public class AnuncioDAO extends GenericDAO<Anuncio> {

	// constructors
	public AnuncioDAO() {
		super.setFilePath(ProjectUtil.getDbFilePath() + this.getClass().getSimpleName() + MarcketplaceConstantes.DB_EXTENSION);
	}

}