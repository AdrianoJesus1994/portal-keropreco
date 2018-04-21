package com.optmize.keropreco.model.repository.impl.dao.jdbc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.optmize.keropreco.model.entity.Supermercado;

@Component
public class SupermercadosJDBCDao {
	
	private Long lastID = 0L;
	private List<Supermercado> supermercados = new ArrayList<Supermercado>();
	
	public SupermercadosJDBCDao() {
		for(Integer i = 0; i < 10; i++) {
			supermercados.add(new Supermercado(i.longValue(), "Supermercado " + i, "Rua " + i, "Ede" + i));
			lastID++;
		}
	}
	
	public Supermercado salvar(Supermercado Supermercado) {
		Supermercado.setIdSupermercado(lastID);
		supermercados.add(Supermercado);
		lastID++;
		return Supermercado;
	}
	
	public Supermercado buscarPorId(Long id) {
		Supermercado retorno = null;
		for(Supermercado v : supermercados) {
			if(v.getIdSupermercado().equals(id));
			retorno = v;
			break;
		}
		return retorno;
	}
	
	public List<Supermercado> listarTodos() {
		return supermercados;
	}
	
	public void remover(Long id) {
		supermercados.removeIf( v -> v.getIdSupermercado().equals(id));
	}
	
	public Supermercado editar(Supermercado Supermercado) {
		return supermercados.set(supermercados.indexOf(Supermercado), Supermercado);
	}

	public Boolean existe(Long id) {
		Supermercado retorno = null;
		for(Supermercado v : supermercados) {
			if(v.getIdSupermercado().equals(id));
			retorno = v;
			break;
		}
		return retorno != null;
	}
}
