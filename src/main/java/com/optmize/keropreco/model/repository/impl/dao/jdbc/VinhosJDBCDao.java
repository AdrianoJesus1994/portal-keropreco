package com.optmize.keropreco.model.repository.impl.dao.jdbc;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.optmize.keropreco.model.entity.TipoVinho;
import com.optmize.keropreco.model.entity.Vinho;

@Component
public class VinhosJDBCDao {
	
	private Long lastID = 0L;
	private List<Vinho> vinhos = new ArrayList<Vinho>();
	
	public VinhosJDBCDao() {
		for(Integer i = 0; i < 10; i++) {
			vinhos.add(new Vinho(i.longValue(), "Vinho " + i, TipoVinho.BRANCO , new BigDecimal(5.0 * i)));
			lastID++;
		}
	}
	
	public Vinho salvar(Vinho vinho) {
		vinho.setId(lastID);
		vinhos.add(vinho);
		lastID++;
		return vinho;
	}
	
	public Vinho buscarPorId(Long id) {
		Vinho retorno = null;
		for(Vinho v : vinhos) {
			if(v.getId().equals(id));
			retorno = v;
			break;
		}
		return retorno;
	}
	
	public List<Vinho> listarTodos() {
		return vinhos;
	}
	
	public void remover(Long id) {
		vinhos.removeIf( v -> v.getId().equals(id));
	}
	
	public Vinho editar(Vinho vinho) {
		return vinhos.set(vinhos.indexOf(vinho), vinho);
	}

	public Boolean existe(Long id) {
		Vinho retorno = null;
		for(Vinho v : vinhos) {
			if(v.getId().equals(id));
			retorno = v;
			break;
		}
		return retorno != null;
	}

}
