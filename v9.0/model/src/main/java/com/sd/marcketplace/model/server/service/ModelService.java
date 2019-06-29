package com.sd.marcketplace.model.server.service;

import java.math.BigDecimal;
import java.util.List;

import org.jgroups.Address;

import com.sd.marcketplace.model.persistencia.table.TableAnuncio;
import com.sd.marcketplace.model.persistencia.table.TableComentario;
import com.sd.marcketplace.model.persistencia.table.TableProduto;
import com.sd.marcketplace.model.persistencia.table.TableUsuario;
import com.sd.marcketplace.model.persistencia.table.TableVenda;
import com.sd.marcketplace.model.server.manager.ModelManager;

import comum.domain.Anuncio;
import comum.domain.Comentario;
import comum.domain.Produto;
import comum.domain.Usuario;
import comum.domain.Venda;
import comum.util.PacoteUtil;
import comum.util.Util;

public class ModelService extends ModelManager {

	protected Address modelGetOneAddress() {
		return modelChannel.getAddress();
	}
	
	protected Object modelGetOneAnuncio(Long id, String identifier) throws Exception {
		try {
			TableAnuncio result = repository.anuncio().getById(id);
			Anuncio retorno = mapper.anuncio().toEntity(result);
			return PacoteUtil.createPacoteRecebido(retorno, identifier);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e);
		}		
	}
	
	protected Object modelGetAllProduto(String identifier) throws Exception {
		try {
			List<TableProduto> result = repository.produto().findAll();
			List<Produto> retorno = mapper.produto().toEntity(result);
			return PacoteUtil.createPacoteRecebido(retorno, identifier);
		} catch (Exception e) {
			throw new Exception();
		}		
	}
	
	protected Object modelGetByFilterUsuario(Usuario filter, String identifier) throws Exception {
		try {
			TableUsuario result = repository.usuario().getUsuarioByInfoLogin(filter.getEmail(), filter.getSenha());
			Util.print(result);
			if (result == null) {
				throw new Exception("Usuario invalido");
			}
			Usuario retorno = mapper.usuario().toEntity(result);
			return PacoteUtil.createPacoteRecebido(retorno, identifier);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}		
	}
	
	protected Object modelGetByFilterAnuncio(Anuncio filter, String identifier) throws Exception {
		try {
			List<TableAnuncio> result = repository.anuncio().getAnunciosByIdProduto(filter.getProduto().getId());
			List<Anuncio> retorno = mapper.anuncio().toEntity(result);
			return PacoteUtil.createPacoteRecebido(retorno, identifier);
		} catch (Exception e) {
			throw new Exception();
		}		
	}
	
	protected Object modelGetByFilterComentario(Comentario filter, String identifier) throws Exception {
		try {
			List<TableComentario> result = repository.comentario().getComentariosByIdAnuncio(filter.getAnuncio().getId());
			List<Comentario> retorno = mapper.comentario().toEntity(result);
			return PacoteUtil.createPacoteRecebido(retorno, identifier);
		} catch (Exception e) {
			throw new Exception();
		}		
	}
	
	protected Usuario modelPostOneUsuario(Usuario entity) throws Exception {
		try {
			TableUsuario table = mapper.usuario().toTable(entity);
			table = repository.usuario().save(table);
			entity = mapper.usuario().toEntity(table);
			return entity;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception();
		}		
	}
	
	protected Anuncio modelPostOneAnuncio(Anuncio entity) throws Exception {
		try {
			TableAnuncio anuncio = mapper.anuncio().toTable(entity);
			TableProduto produto = repository.produto().getByNome(anuncio.getProduto().getNome());
			TableUsuario vendedor = repository.usuario().getById(anuncio.getVendedor().getId());
			
			Util.print("\n\n\n produto:");
			Util.print(produto);
			if (produto == null) {
				produto = repository.produto().save(anuncio.getProduto());
			}
			anuncio.setVendedor(vendedor);
			anuncio.setProduto(produto);
			anuncio = repository.anuncio().save(anuncio);
			entity = mapper.anuncio().toEntity(anuncio);
			return entity;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception();
		}		
	}
	
	protected Comentario modelPostOneComentario(Comentario entity) throws Exception {
		try {
			TableAnuncio anuncio = repository.anuncio().getById(entity.getAnuncio().getId());
			entity.setAnuncio(mapper.anuncio().toEntity(anuncio));
			TableComentario comentario = mapper.comentario().toTable(entity);
			comentario = repository.comentario().save(comentario);
			entity = mapper.comentario().toEntity(comentario);
			return entity;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception();
		}		
	}
	
	protected Venda modelPostOneVenda(Venda entity) throws Exception {
		try {
			TableVenda venda = mapper.venda().toTable(entity);
			
			TableAnuncio anuncio = venda.getAnuncio();
			anuncio.setQuantidade(anuncio.getQuantidade()-venda.getQuantidade());
			anuncio = repository.anuncio().save(anuncio);
			
			TableUsuario consumidor = venda.getConsumidor();
			consumidor.setSaldo(BigDecimal.valueOf(consumidor.getSaldo().doubleValue()-(venda.getQuantidade().longValue()*anuncio.getPreco().doubleValue())));
			consumidor = repository.usuario().save(consumidor);
			
			TableUsuario vendedor = repository.usuario().getById(anuncio.getVendedor().getId());
			vendedor.setSaldo(BigDecimal.valueOf(vendedor.getSaldo().doubleValue()+(venda.getQuantidade().longValue()*anuncio.getPreco().doubleValue())));
			vendedor = repository.usuario().save(vendedor);
			
			venda.setAnuncio(anuncio);
			venda.setConsumidor(consumidor);
			
			venda = repository.venda().save(venda);
			entity = mapper.venda().toEntity(venda);
			return entity;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}		
	}
	
	protected Usuario modelDeleteOneUsuario(Long id) throws Exception {
		try {
			TableUsuario table = repository.usuario().getById(id);
			repository.usuario().delete(table);
			Usuario entity = mapper.usuario().toEntity(table);
			return entity;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception();
		}		
	}
	
	
}
