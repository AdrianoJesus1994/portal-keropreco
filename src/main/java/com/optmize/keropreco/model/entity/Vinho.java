package com.optmize.keropreco.model.entity;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.NumberFormat;

public class Vinho {
	
	private Long id;
	
	@NotBlank
	private String nome;
	
	@NotNull
	private TipoVinho tipo;
	
	@NotNull
	@NumberFormat(pattern = "#,##0.00")
	private BigDecimal valor;
	
	
	public Vinho() {
		this.id = 0L;
		this.nome = "";
		this.tipo = TipoVinho.BRANCO;
		this.valor = new BigDecimal(0);
	}
	
	public Vinho(Long id, String nome, TipoVinho tipo, BigDecimal valor) {
		this.id = id;
		this.nome = nome;
		this.tipo = tipo;
		this.valor = valor;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public TipoVinho getTipo() {
		return tipo;
	}
	public void setTipo(TipoVinho tipo) {
		this.tipo = tipo;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vinho other = (Vinho) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
  
}
