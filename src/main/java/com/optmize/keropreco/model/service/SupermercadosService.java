package com.optmize.keropreco.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.optmize.keropreco.common.constants.Constantes;
import com.optmize.keropreco.model.entity.Supermercado;
import com.optmize.keropreco.model.repository.interfaces.SupermercadosRepositoryInterface;

@Service
public class SupermercadosService {
	
	@Autowired
	@Qualifier(Constantes.AMBIENTE_REPOSTORY_ATUAL)
	private SupermercadosRepositoryInterface repository;
	
	
	public Supermercado salvar(Supermercado supermercado) {
		return getRepository().salvar(supermercado);
	}

	public Supermercado buscarPorId(Long id) {
		return getRepository().buscarPorId(id);
	}

	public List<Supermercado> listarTodos() {
		return getRepository().listarTodos();
	}

	public void remover(Long id) {
		getRepository().remover(id);
	}

	public Supermercado editar(Supermercado supermercado) {
		return getRepository().editar(supermercado);
	}

	public Boolean existe(Long id) {
		return getRepository().existe(id);
	}
	
	public SupermercadosRepositoryInterface getRepository() {
		return repository;
	}
}
