package com.sd.marcketplace.model.repositorio.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.sd.marcketplace.model.domain.Anuncio;
import com.sd.marcketplace.model.repositorio.AnuncioRepositorio;


public class AnuncioRepositorioImpl implements AnuncioRepositorio {

	private List<Anuncio> list;
		
	public AnuncioRepositorioImpl() {
		this.list = new ArrayList<Anuncio>();
	}
	
	public List<Anuncio> findAll() {
		return this.list;
	}

	public List<Anuncio> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Anuncio> findAllById(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	public <S extends Anuncio> List<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	public void flush() {
		// TODO Auto-generated method stub
		
	}

	public <S extends Anuncio> S saveAndFlush(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	public void deleteInBatch(Iterable<Anuncio> entities) {
		// TODO Auto-generated method stub
		
	}

	public void deleteAllInBatch() {
		// TODO Auto-generated method stub
		
	}

	public Anuncio getOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public <S extends Anuncio> List<S> findAll(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	public <S extends Anuncio> List<S> findAll(Example<S> example, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	public Page<Anuncio> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	public <S extends Anuncio> S save(S entity) {
		// TODO Auto-generated method stub
		list.add(entity);
		return entity;
	}

	public Optional<Anuncio> findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean existsById(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}

	public void delete(Anuncio entity) {
		// TODO Auto-generated method stub
		
	}

	public void deleteAll(Iterable<? extends Anuncio> entities) {
		// TODO Auto-generated method stub
		
	}

	public void deleteAll() {
		// TODO Auto-generated method stub
		this.list = new ArrayList<Anuncio>();
	}

	public <S extends Anuncio> Optional<S> findOne(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	public <S extends Anuncio> Page<S> findAll(Example<S> example, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	public <S extends Anuncio> long count(Example<S> example) {
		// TODO Auto-generated method stub
		return 0;
	}

	public <S extends Anuncio> boolean exists(Example<S> example) {
		// TODO Auto-generated method stub
		return false;
	}

}
