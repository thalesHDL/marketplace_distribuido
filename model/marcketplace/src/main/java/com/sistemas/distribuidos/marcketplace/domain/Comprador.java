package com.sistemas.distribuidos.marcketplace.domain;


import java.io.Serializable;


public class Comprador extends Usuario implements Serializable {

	// constructors
	public Comprador() {
		// Empty constructor
	}

	// hash - equals - tostring
	@Override
	public String toString() {
		return "Comprador: " + super.toString();
	}

}