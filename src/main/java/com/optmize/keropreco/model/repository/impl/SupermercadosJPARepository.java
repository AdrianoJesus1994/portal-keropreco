package com.optmize.keropreco.model.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.optmize.keropreco.common.constants.Constantes;
import com.optmize.keropreco.model.entity.Supermercado;
import com.optmize.keropreco.model.repository.impl.dao.jpa.SupermercadoJPADao;
import com.optmize.keropreco.model.repository.interfaces.SupermercadosRepositoryInterface;

@Qualifier(Constantes.AMBIENTE_REPOSTORY_SPRING)
@Component
public class SupermercadosJPARepository implements SupermercadosRepositoryInterface {

	@Autowired
	private SupermercadoJPADao dao;
	
	@Override
	public Supermercado salvar(Supermercado supermercado) {
		return getDao().save(supermercado);
	}

	@Override
	public Supermercado buscarPorId(Long id) {
		return getDao().findOne(id);
	}

	@Override
	public List<Supermercado> listarTodos() {
		return getDao().findAll();
	}

	@Override
	public void remover(Long id) {
		getDao().delete(id);
	}

	@Override
	public Supermercado editar(Supermercado supermercado) {
		return getDao().save(supermercado);
	}

	@Override
	public Boolean existe(Long id) {
		return getDao().exists(id);
	}
	
	public SupermercadoJPADao getDao() {
		return dao;
	}
}
