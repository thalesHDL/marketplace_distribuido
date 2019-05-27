package com.sd.marcketplace.model.domain;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="tbs_transacao")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of= {"id"})
public class Transacao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_transacao")
	private Long id;
	
	// FIXME fazer o mapeamento para a entidade VendedorProduto (tbs_vendedor_produto)
	private VendedorProduto vendedorProduto;
	
	// FIXME fazer o mapeamento para a entidade Usuario (tbs_usuario)
	private Usuario consumidor;
	
	@Column(name="dt_transacao")
	private LocalDate dtTransacao;
	
	@Column(name="num_quantidade")
	private Long quantidade;

}
