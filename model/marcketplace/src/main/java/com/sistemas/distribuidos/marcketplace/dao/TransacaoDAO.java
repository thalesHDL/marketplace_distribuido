package com.sistemas.distribuidos.marcketplace.dao;


import com.sistemas.distribuidos.marcketplace.domain.Transacao;
import com.sistemas.distribuidos.marcketplace.util.MarcketplaceConstantes;
import com.sistemas.distribuidos.marcketplace.util.ProjectUtil;


public class TransacaoDAO extends GenericDAO<Transacao> {

	// constructors
	public TransacaoDAO() {
		super.setFilePath(ProjectUtil.getDbFilePath() + this.getClass().getSimpleName() + MarcketplaceConstantes.DB_EXTENSION);
	}

}