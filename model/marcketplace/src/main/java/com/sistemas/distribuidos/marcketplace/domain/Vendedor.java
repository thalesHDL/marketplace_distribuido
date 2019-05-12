package com.sistemas.distribuidos.marcketplace.domain;


import java.io.Serializable;


public class Vendedor extends Usuario implements Serializable {

	// constructors
	public Vendedor() {
		// Empty constructor
	}

	// hash - equals - tostring
	@Override
	public String toString() {
		return "Vendedor: " + super.toString();
	}

}