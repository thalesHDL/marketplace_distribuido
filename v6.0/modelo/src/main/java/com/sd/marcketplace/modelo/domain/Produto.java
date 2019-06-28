package com.sd.marcketplace.modelo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Table(name = "tbs_produto")
@Entity
public class Produto {

	@Id
	@GeneratedValue
	@Column(name = "id_produto")
	private Long id;
	
	@Column(name = "nm_produto")
	private Long nmProduto;
	
}
