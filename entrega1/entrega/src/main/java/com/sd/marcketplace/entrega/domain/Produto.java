package com.sd.marcketplace.entrega.domain;

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
@Table(name="tbs_produto")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of= {"id"})
public class Produto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_produto")
	private Long id;
	
	@Column(name="tx_nome")
	private String nome;

}
