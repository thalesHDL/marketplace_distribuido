package com.sistemas.distribuidos.marcketplace.dao;


import com.sistemas.distribuidos.marcketplace.domain.MensagemAnuncio;
import com.sistemas.distribuidos.marcketplace.util.MarcketplaceConstantes;
import com.sistemas.distribuidos.marcketplace.util.ProjectUtil;


public class MensagemAnuncioDAO extends GenericDAO<MensagemAnuncio> {

	// constructors
	public MensagemAnuncioDAO() {
		super.setFilePath(ProjectUtil.getDbFilePath() + this.getClass().getSimpleName() + MarcketplaceConstantes.DB_EXTENSION);
	}
	
}