package com.sistemas.distribuidos.marcketplace.dao;

import com.sistemas.distribuidos.marcketplace.util.MarcketplaceConstantes;

public class GenericDAO<E> {

	// constructors
	public GenericDAO() {
		// Empty constructor
	}

	public E save(E o) {
		String caminho = MarcketplaceConstantes.FILE_PATH + o.getClass().getSimpleName();
		return o;
	}

}