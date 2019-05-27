package com.sd.marcketplace.model.domain;

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
@Table(name="tbs_usuario")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of= {"id"})
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_usuario")
	private Long id;
	
	@Column(name="tx_email", length=30)
	private String email;
	
	@Column(name="tx_senha", length=20)
	private String senha;
	
	@Column(name="tx_nome", length=20)
	private String nome;
	
	@Column(name="tx_telefone", length=14)
	private String telefone;
	
	@Column(name="vl_saldo")
	private BigDecimal saldo;

}
