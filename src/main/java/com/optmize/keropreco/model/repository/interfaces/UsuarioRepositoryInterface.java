package com.optmize.keropreco.model.repository.interfaces;

import org.springframework.stereotype.Component;

import com.optmize.keropreco.model.entity.Usuario;

@Component
public interface UsuarioRepositoryInterface {

	boolean existe(Usuario usuario);
	/*
	public boolean inserir(Usuario novoUsuario);
	
	public boolean remover(Usuario usuario);
	
	public boolean editar(Usuario usuario);
	
	public List<Usuario> listarTodos();
	*/

}