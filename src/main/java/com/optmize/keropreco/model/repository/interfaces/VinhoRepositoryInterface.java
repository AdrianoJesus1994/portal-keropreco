package com.optmize.keropreco.model.repository.interfaces;

import java.util.List;

import org.springframework.stereotype.Component;

import com.optmize.keropreco.model.entity.Vinho;

@Component
public interface VinhoRepositoryInterface {

	public Vinho salvar(Vinho vinho);
	
	public Vinho buscarPorId(Long id);
	
	public List<Vinho> listarTodos();
	
	public void remover(Long id);
	
	public Vinho editar(Vinho vinho);

	public Boolean existe(Long id);
}
