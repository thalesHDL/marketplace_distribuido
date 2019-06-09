package com.sd.marcketplace.entrega.domain;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Anuncio {
	
	@EqualsAndHashCode.Include
    @Id
    @GeneratedValue
    @Getter @Setter
	private Long id;
	
	@Getter @Setter
	private VendedorProduto vendedorProduto;
	
	@Getter @Setter
	private LocalDate dtPublicacao;

	@Override
	public String toString() {
		return "Anuncio [id=" + id + ", vendedorProduto=" + vendedorProduto + ", dtPublicacao=" + dtPublicacao + "]";
	}
}
