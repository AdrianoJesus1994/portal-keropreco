package com.optmize.keropreco.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.optmize.keropreco.model.entity.Usuario;
import com.optmize.keropreco.model.repository.interfaces.UsuarioRepositoryInterface;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepositoryInterface repository;
	
	public Boolean existe(Usuario usuario) {
		return getRepository().existe(usuario);
	}
	
	public UsuarioRepositoryInterface getRepository() {
		return repository;
	}
}
