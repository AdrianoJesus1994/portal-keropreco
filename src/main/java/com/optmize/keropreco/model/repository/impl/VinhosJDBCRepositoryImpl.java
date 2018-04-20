package com.optmize.keropreco.model.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.optmize.keropreco.common.constants.Constantes;
import com.optmize.keropreco.model.entity.Vinho;
import com.optmize.keropreco.model.repository.impl.dao.jdbc.VinhosJDBCDao;
import com.optmize.keropreco.model.repository.interfaces.VinhosRepositoryInterface;

@Qualifier(Constantes.AMBIENTE_REPOSTORY_PI)
@Component
public class VinhosJDBCRepositoryImpl implements VinhosRepositoryInterface {

	@Autowired
	private VinhosJDBCDao dao;
	
	@Override
	public Vinho salvar(Vinho vinho) {
		return getDao().salvar(vinho);
	}

	@Override
	public Vinho buscarPorId(Long id) {
		return getDao().buscarPorId(id);
	}

	@Override
	public List<Vinho> listarTodos() {
		return getDao().listarTodos();
	}

	@Override
	public void remover(Long id) {
		getDao().remover(id);
	}

	@Override
	public Vinho editar(Vinho vinho) {
		return getDao().editar(vinho);
	}
	
	@Override
	public Boolean existe(Long id) {
		return getDao().existe(id);
	}
	
	private VinhosJDBCDao getDao() {
		return dao;
	}
	

}
