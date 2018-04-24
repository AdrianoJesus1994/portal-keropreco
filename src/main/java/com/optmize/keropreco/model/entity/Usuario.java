package com.optmize.keropreco.model.entity;

import org.hibernate.validator.constraints.NotBlank;

public class Usuario {
	
	private Long idUsuario;
	private String nome;
	
	@NotBlank
	private String login;
	
	@NotBlank
	private String senha;
	
	public Usuario() {
		this.idUsuario = 0l;
		this.nome = "";
		this.login = "";
		this.senha = "";
	}
	
	public Usuario(String nome, String login, String senha) {
		super();
		this.nome = nome;
		this.login = login;
		this.senha = senha;
	}
	
	public Usuario(Long idUsuario, String nome, String login, String senha) {
		this(nome,login,senha);
		this.idUsuario = idUsuario;
	}
	

	public Long getIdUsuario() {
		return idUsuario;
	}
	
	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getLogin() {
		return login;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
}
