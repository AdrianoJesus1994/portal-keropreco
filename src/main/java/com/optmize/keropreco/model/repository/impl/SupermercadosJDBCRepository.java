package com.optmize.keropreco.model.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.optmize.keropreco.common.constants.Constantes;
import com.optmize.keropreco.model.entity.Supermercado;
import com.optmize.keropreco.model.repository.impl.dao.jdbc.SupermercadosJDBCDao;
import com.optmize.keropreco.model.repository.interfaces.SupermercadosRepositoryInterface;

@Qualifier(Constantes.AMBIENTE_REPOSTORY_PI)
@Component
public class SupermercadosJDBCRepository implements SupermercadosRepositoryInterface {

	@Autowired
	private SupermercadosJDBCDao dao;
	
	@Override
	public Supermercado salvar(Supermercado Supermercado) {
		return getDao().salvar(Supermercado);
	}

	@Override
	public Supermercado buscarPorId(Long id) {
		return getDao().buscarPorId(id);
	}

	@Override
	public List<Supermercado> listarTodos() {
		return getDao().listarTodos();
	}

	@Override
	public void remover(Long id) {
		getDao().remover(id);
	}

	@Override
	public Supermercado editar(Supermercado Supermercado) {
		return getDao().editar(Supermercado);
	}

	@Override
	public Boolean existe(Long id) {
		return getDao().existe(id);
	}

	private SupermercadosJDBCDao getDao() {
		return dao;
	}
}
