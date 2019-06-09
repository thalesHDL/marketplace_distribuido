package com.sd.marcketplace.modelo.db.dao;

import java.util.List;

public class BasicoDAO <E> {
	
	private List<E> list;
	
	
	public void add(E entity) {
		list.add(entity);
	}
	
	public void remove(E entity) {
		list.remove(entity);
	}
	
	public void update(E entity) {
		list.set(list.indexOf(entity), entity);
	}
	
	public List<E> getAll() {
		return list;
	}
	
	// TODO: find by id
	
	// TODO: find by filter
}
