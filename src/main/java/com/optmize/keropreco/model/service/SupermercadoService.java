package com.optmize.keropreco.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.optmize.keropreco.common.constants.Constantes;
import com.optmize.keropreco.model.entity.Supermercado;
import com.optmize.keropreco.model.repository.interfaces.SupermercadoRepositoryInterface;

@Service
public class SupermercadoService {
	
	@Autowired
	private SupermercadoRepositoryInterface repository;
	
	
	public Boolean salvar(Supermercado supermercado) {
		return getRepository().salvar(supermercado);
	}

	public Supermercado buscarPorId(Long id) {
		return getRepository().buscarPorId(id);
	}

	public List<Supermercado> listarTodos() {
		return getRepository().listarTodos();
	}

	public Boolean remover(Long id) {
		return getRepository().remover(id);
	}

	public Boolean editar(Supermercado supermercado) {
		return getRepository().editar(supermercado);
	}

	public Boolean existe(Long id) {
		return getRepository().existe(id);
	}
	
	public SupermercadoRepositoryInterface getRepository() {
		return repository;
	}
}
