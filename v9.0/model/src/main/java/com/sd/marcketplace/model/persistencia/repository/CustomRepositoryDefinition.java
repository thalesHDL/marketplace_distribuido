package com.sd.marcketplace.model.persistencia.repository;

import java.util.List;

public interface CustomRepositoryDefinition<T, ID> {
	
	public List<T> findAll();
	
	public T save(T table) throws Exception;
	
	public T getOne(ID id);
	
}
