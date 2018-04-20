package com.optmize.keropreco.model.repository.impl.dao.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.optmize.keropreco.model.entity.Vinho;

public interface VinhosJPADao extends JpaRepository<Vinho, Long>{
	
}
