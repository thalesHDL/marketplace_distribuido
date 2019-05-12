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

	public E save(E obj) {
		System.out.println(this.filePath);
		FileUtil.writeBinaryFile(this.filePath, obj);
		return obj;
	}

	public List<E> getAll() {
		return null;
	}

}