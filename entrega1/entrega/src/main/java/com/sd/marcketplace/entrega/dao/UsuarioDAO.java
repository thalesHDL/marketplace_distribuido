package com.sd.marcketplace.entrega.dao;

import java.util.ArrayList;
import java.util.List;

import com.sd.marcketplace.entrega.domain.Usuario;

public class UsuarioDAO {
	
	private List<Usuario> list;
	
	private static Long ID = 0L;
	
	public UsuarioDAO() {
		this.list = new ArrayList<Usuario>();
	}
	
	public Usuario save(Usuario u) throws Exception {
		if (u.getId() == null) {
			ID += 1;
			u.setId(ID);
		} else {
			int index = this.list.indexOf(u);
			if (index == -1) {
				throw new Exception("Usuario nao existe");
			}
			this.list.add(index, u);
		}
		this.list.add(u);
		return u;
	}
	
	public void deleteById(Long id) throws Exception {
		Usuario u = this.getById(id);
		if (u == null) {
			throw new Exception("Usuario nao existe");
		}
		this.list.remove(u);
	}
	
	public void delete(Usuario u) throws Exception {
		int index = this.list.indexOf(u);
		if (index == -1) {
			throw new Exception("Usuario nao existe");
		}
		this.list.remove(index);
	}
	
	public List<Usuario> getAll() {
		return this.list;
	}
	
	public List<Usuario> getByFilter(Usuario usuario) {
		List<Usuario> result = new ArrayList<Usuario>();
		Boolean aux = false;
		for (Usuario u : this.list) {
			aux = false;
			if (usuario.getId() == null || usuario.getId().equals(u.getId())) {
				aux = true;
			}
			if (usuario.getEmail() == null || usuario.getEmail().contains(u.getEmail())) {
				aux = true;
			}
			if (usuario.getNome() == null || usuario.getNome().contains(u.getNome())) {
				aux = true;
			}
			if (usuario.getSaldo() == null || usuario.getSaldo().equals(u.getSaldo())) {
				aux = true;
			}
			if (usuario.getSenha() == null || usuario.getSenha().contains(u.getSenha())) {
				aux = true;
			}
			if (usuario.getTelefone() == null || usuario.getTelefone().contains(u.getTelefone())) {
				aux = true;
			}
			if (aux) {
				result.add(u);
			}
		}
		return result;
	}
	
	public Usuario getById(Long id) {
		for (Usuario u : this.list) {
			if (u.getId().equals(id)) {
				return u;
			}
		}
		return null;
	}

}
