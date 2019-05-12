package com.sistemas.distribuidos.marcketplace.exception;


public class PersistenceExeception extends Exception {

	private static final String ERROR_OPEN_FILE_DB = "Não foi possível acessar a base de dados";

	public PersistenceExeception(String msg) {
		System.out.println(msg);
	}

	public static final String getErrorOpenFileDb() {
		return ERROR_OPEN_FILE_DB;
	}

}