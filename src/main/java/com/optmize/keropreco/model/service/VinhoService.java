package com.optmize.keropreco.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.optmize.keropreco.common.constants.Constantes;
import com.optmize.keropreco.model.entity.Vinho;
import com.optmize.keropreco.model.repository.interfaces.VinhoRepositoryInterface;

@Service
public class VinhoService {
	
	@Autowired
	private VinhoRepositoryInterface repository;

	public Vinho salvar(Vinho vinho) {
		return getRepository().salvar(vinho);
	}
	
	public Vinho buscarPorId(Long id) {
		return getRepository().buscarPorId(id); 
	}
	
	public List<Vinho> listarTodos() {
		return getRepository().listarTodos();
	}
	
	public void remover(Long id) {
		if(existe(id)) {
			getRepository().remover(id);
		}
	}
	
	public Vinho editar(Vinho vinho) {
		if(existe(vinho.getId())) {
			return getRepository().editar(vinho);
		}
		return null;
	}
	
	public Boolean existe(Long id) {
		return getRepository().existe(id);
	}
	
	private VinhoRepositoryInterface getRepository() {
		return repository;
	}
	
}
