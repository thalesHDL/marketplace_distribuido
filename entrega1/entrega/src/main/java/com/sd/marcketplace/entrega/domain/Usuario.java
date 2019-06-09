package com.sd.marcketplace.entrega.domain;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Usuario {
	
	@EqualsAndHashCode.Include
    @Id
    @GeneratedValue
    @Getter @Setter
	private Long id;
	
	@Getter @Setter
	private String email;
	
	@Getter @Setter
	private String senha;
	
	@Getter @Setter
	private String nome;
	
	@Getter @Setter
	private String telefone;
	
	@Getter @Setter
	private BigDecimal saldo;

}
