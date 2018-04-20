package com.optmize.keropreco.model.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.optmize.keropreco.common.constants.Constantes;
import com.optmize.keropreco.model.entity.Vinho;
import com.optmize.keropreco.model.repository.impl.dao.jpa.VinhosJPADao;
import com.optmize.keropreco.model.repository.interfaces.VinhosRepositoryInterface;

@Qualifier(Constantes.AMBIENTE_REPOSTORY_SPRING)
@Component
public class VinhosJPARepositoryImpl implements VinhosRepositoryInterface {
	
	@Autowired
	private VinhosJPADao dao;

	@Override
	public Vinho salvar(Vinho vinho) {
		return getDao().save(vinho);
	}
	
	@Override
	public Vinho buscarPorId(Long id) {
		return getDao().findOne(id); 
	}

	@Override
	public List<Vinho> listarTodos() {
		return getDao().findAll();
	}

	@Override
	public void remover(Long id) {
		getDao().delete(id);
	}

	@Override
	public Vinho editar(Vinho vinho) {
		return getDao().save(vinho);
	}

	@Override
	public Boolean existe(Long id) {
		return getDao().exists(id);
	}
	
	public VinhosJPADao getDao() {
		return dao;
	}

}
