package com.sistemas.distribuidos.marcketplace.dao;

import java.util.List;
import com.sistemas.distribuidos.marcketplace.util.FileUtil;


public class GenericDAO<E> {

	private String filePath;
	protected void setFilePath(String path) {
		this.filePath = path;
	}

	// constructors
	public GenericDAO() {
		// Empty constructor
	}

	public void save(E obj) {
		System.out.println("Saving : " + obj + " - on : " + this.filePath);
		FileUtil.writeBinaryFile(this.filePath, obj);
	}

	public List<E> getAll() {
		System.out.println("Getting all data from : " + this.filePath);
		return (List<E>) FileUtil.readBinaryFile(this.filePath);
	}

}