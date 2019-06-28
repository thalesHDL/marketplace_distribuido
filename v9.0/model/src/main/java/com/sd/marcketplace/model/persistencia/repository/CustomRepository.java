package com.sd.marcketplace.model.persistencia.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public class CustomRepository<T, ID> implements CustomRepositoryDefinition<T, ID> {

	@PersistenceContext
	private EntityManager entityManager;
		
	@Override
	public List<T> findAll() {
		return null;
	}

	@Override
	public T save(T table) throws Exception {
		return entityManager.merge(table);
	}

	@Override
	public T getOne(ID id) {
		return null;
	}
	
	public EntityTransaction save(T table, boolean ok) throws Exception {
		try {
			ok = true;
			table = entityManager.merge(table);
		} catch (Exception e) {
			ok = false;
		}
		return entityManager.getTransaction();
	}
	
	public EntityTransaction getTransaction() {
		return entityManager.getTransaction();
	}

}
