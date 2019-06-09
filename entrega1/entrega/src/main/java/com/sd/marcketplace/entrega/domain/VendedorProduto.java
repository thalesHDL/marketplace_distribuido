package com.sd.marcketplace.entrega.domain;

import java.math.BigDecimal;

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
@Table(name="tbs_vendedor_produto")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of= {"id"})
public class VendedorProduto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_vendedor_produto")
	private Long id;
	
	// FIXME fazer o mapeamento para a entidade Usuario (tbs_usuario)
	private Usuario vendedor;
	
	// FIXME fazer o mapeamento para a entidade Produto (tbs_produto)
	private Produto produto;
	
	@Column(name="tx_descricao_produto", length=50)
	private String descricaoProduto;
	
	@Column(name="vl_preco_produto")
	private BigDecimal precoProduto;
	
	@Column(name="num_quantidade")
	private Long quantidade;

}
