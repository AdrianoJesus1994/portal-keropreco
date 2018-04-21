package com.optmize.keropreco.model.repository.interfaces;

import java.util.List;

import org.springframework.stereotype.Component;

import com.optmize.keropreco.model.entity.Supermercado;

@Component
public interface SupermercadosRepositoryInterface {
	
	public Supermercado salvar(Supermercado supermercado);
	
	public Supermercado buscarPorId(Long id);
	
	public List<Supermercado> listarTodos();
	
	public void remover(Long id);
	
	public Supermercado editar(Supermercado supermercado);

	public Boolean existe(Long id);
}
