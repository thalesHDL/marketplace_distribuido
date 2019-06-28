package com.sd.marcketplace.entrega.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@SuppressWarnings("serial")
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Usuario implements Serializable {
	
	@EqualsAndHashCode.Include
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

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", email=" + email + ", senha=" + senha + ", nome=" + nome + ", telefone="
				+ telefone + ", saldo=" + saldo + "]";
	}

}
