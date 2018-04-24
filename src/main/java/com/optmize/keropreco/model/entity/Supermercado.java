package com.optmize.keropreco.model.entity;

import org.hibernate.validator.constraints.NotBlank;

public class Supermercado {
	
	private Long idSupermercado;
	
	@NotBlank
	private String nome;
	
	private String localizacao;
	
	private String endereco;
	
	public Supermercado() {
		this.idSupermercado = 0L;
		this.nome = "";
		this.localizacao = "";
		this.endereco = "";
	}
	
	public Supermercado(Long idSupermercado, String nome, String localizacao, String endereco) {
		super();
		this.idSupermercado = idSupermercado;
		this.nome = nome;
		this.localizacao = localizacao;
		this.endereco = endereco;
	}


	public Long getIdSupermercado() {
		return idSupermercado;
	}

	public void setIdSupermercado(Long idSupermercado) {
		this.idSupermercado = idSupermercado;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLocalizacao() {
		return localizacao;
	}

	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}
	
	public String getEndereco() {
		return endereco;
	}
	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idSupermercado == null) ? 0 : idSupermercado.hashCode());
		result = prime * result + ((localizacao == null) ? 0 : localizacao.hashCode());
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
		Supermercado other = (Supermercado) obj;
		if (idSupermercado == null) {
			if (other.idSupermercado != null)
				return false;
		} else if (!idSupermercado.equals(other.idSupermercado))
			return false;
		if (localizacao == null) {
			if (other.localizacao != null)
				return false;
		} else if (!localizacao.equals(other.localizacao))
			return false;
		return true;
	}
	
}
