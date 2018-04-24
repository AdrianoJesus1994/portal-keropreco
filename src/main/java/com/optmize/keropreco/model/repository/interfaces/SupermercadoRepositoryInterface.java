package com.optmize.keropreco.model.repository.interfaces;

import java.util.List;

import org.springframework.stereotype.Component;

import com.optmize.keropreco.model.entity.Supermercado;

@Component
public interface SupermercadoRepositoryInterface {
	
	public Boolean salvar(Supermercado supermercado);
	
	public Supermercado buscarPorId(Long id);
	
	public List<Supermercado> listarTodos();
	
	public Boolean remover(Long id);
	
	public Boolean editar(Supermercado supermercado);

	public Boolean existe(Long id);
}
