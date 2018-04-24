package com.optmize.keropreco.model.repository.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.optmize.keropreco.model.entity.Supermercado;
import com.optmize.keropreco.model.repository.BaseRepository;
import com.optmize.keropreco.model.repository.interfaces.SupermercadoRepositoryInterface;

@Repository
public class SupermercadoJDBCRepositoryImpl extends BaseRepository implements SupermercadoRepositoryInterface {

	private static final String NOME_TABELA = " TB_SUPERMERCADO ";
	
	private static final String COLUNA_ID = "ID_SUPERMERCADO";
	private static final String COLUNA_NOME = "NOME";
	private static final String COLUNA_ENDERECO = "ENDERECO";
	private static final String COLUNA_LOCALIZACAO = "LOCALIZACAO";
	
	public Boolean salvar(Supermercado supermercado) {
		
		boolean inseriuComSucesso = false;
		
		String sql = "INSERT INTO "
				.concat(super.getNomeSchemma())
				.concat(NOME_TABELA)
				.concat("(")
				.concat(COLUNA_NOME)
				.concat(",")
				.concat(COLUNA_ENDERECO)
				.concat(",")
				.concat(COLUNA_LOCALIZACAO)
				.concat(")")
				.concat(" VALUES ")
				.concat("(?,?,?)");

		try {
			PreparedStatement ps = super.getPreparedStatement(sql);
			ps.setString(1, supermercado.getNome());
			ps.setString(2, supermercado.getEndereco());
			ps.setString(3, supermercado.getLocalizacao());

			ps.executeUpdate();

			super.destroyConnection();
			inseriuComSucesso = true;

		} catch (SQLException se) {
			System.out.println("Erro de Insert no SQL");
			System.out.println("Mensagem :" + se.getMessage());
			System.out.println("Cod.       :" + se.getErrorCode());
			System.out.println("SQL Sate:" + se.getSQLState());
		}
				
		return inseriuComSucesso;
	}
	
	public Supermercado buscarPorId(Long id) {
		
		List<Supermercado> supermercados = new LinkedList<Supermercado>();

		String sql = "SELECT "
								.concat(COLUNA_ID)
								.concat(",")
								.concat(COLUNA_NOME)
								.concat(",")
								.concat(COLUNA_LOCALIZACAO)
								.concat(",")
								.concat(COLUNA_ENDERECO)
								.concat(" FROM ")
								.concat(super.getNomeSchemma())
								.concat(NOME_TABELA)
								.concat(" WHERE ")
								.concat(COLUNA_ID)
								.concat(" = ?");
		
		try {
			
			PreparedStatement ps = super.getPreparedStatement(sql);
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {				
				supermercados.add(new Supermercado(rs.getLong(COLUNA_ID), rs.getString(COLUNA_NOME), rs.getString(COLUNA_LOCALIZACAO), rs.getString(COLUNA_ENDERECO)));
			}
			rs.close();
			super.destroyConnection();
		} catch (SQLException e) {
			System.out.println("Erro de Consulta: " + e.getMessage());
		}
		
		return !supermercados.isEmpty() ? supermercados.get(0) : null; 
	}
	
	public List<Supermercado> listarTodos() {

		List<Supermercado> supermercados = new LinkedList<Supermercado>();

		String sql = "SELECT "
								.concat(COLUNA_ID)
								.concat(",")
								.concat(COLUNA_NOME)
								.concat(",")
								.concat(COLUNA_LOCALIZACAO)
								.concat(",")
								.concat(COLUNA_ENDERECO)
								.concat(" FROM ")
								.concat(super.getNomeSchemma())
								.concat(NOME_TABELA);
		
		try {
			ResultSet rs = super.getStatement().executeQuery(sql);
			while (rs.next()) {				
				supermercados.add(new Supermercado(rs.getLong(COLUNA_ID), rs.getString(COLUNA_NOME), rs.getString(COLUNA_LOCALIZACAO), rs.getString(COLUNA_ENDERECO)));
			}
			rs.close();
			super.destroyConnection();
		} catch (SQLException e) {
			System.out.println("Erro de Consulta: " + e.getMessage());
		}

		return supermercados;
	}
	
	public Boolean remover(Long id) {
		
		boolean removeuComSucesso = false;
		
		String sql = "DELETE FROM "
									.concat(super.getNomeSchemma())
									.concat(NOME_TABELA)
									.concat(" WHERE ")
									.concat(COLUNA_ID)
									.concat(" = ?");

		try {
			
			PreparedStatement ps = super.getPreparedStatement(sql);
			ps.setLong(1, id);
			removeuComSucesso = ps.executeUpdate() > 0;
			super.destroyConnection();

		} catch (SQLException se) {
			System.out.println("Erro de Insert no SQL");
			System.out.println("Mensagem :" + se.getMessage());
			System.out.println("Cod.       :" + se.getErrorCode());
			System.out.println("SQL Sate:" + se.getSQLState());
		}
		
		return removeuComSucesso;
	}
	
	public Boolean editar(Supermercado supermercado) {
		
		boolean editouComSucesso = false;

		String sql = "UPDATE "
		.concat(super.getNomeSchemma())
		.concat(NOME_TABELA)
		.concat(" SET ")
		.concat(COLUNA_NOME)
		.concat(" = ?")
		.concat(",")
		.concat(COLUNA_LOCALIZACAO)
		.concat(" = ?")
		.concat(",")
		.concat(COLUNA_ENDERECO)
		.concat(" = ?")
		.concat(" WHERE ")
		.concat(COLUNA_ID)
		.concat(" = ?");
		
		try {
			PreparedStatement ps = super.getPreparedStatement(sql);
			ps.setString(1, supermercado.getNome());
			ps.setString(2, supermercado.getLocalizacao());
			ps.setString(3, supermercado.getEndereco());
			ps.setLong(4, supermercado.getIdSupermercado());

			editouComSucesso = ps.executeUpdate() > 0;
			super.destroyConnection();

		} catch (SQLException se) {
			System.out.println("Erro de Insert no SQL");
			System.out.println("Mensagem :" + se.getMessage());
			System.out.println("Cod.       :" + se.getErrorCode());
			System.out.println("SQL Sate:" + se.getSQLState());
		}
		
		return editouComSucesso;		
	}

	public Boolean existe(Long id) {
		
		List<Supermercado> supermercados = new LinkedList<Supermercado>();

		String sql = "SELECT "
								.concat(COLUNA_ID)
								.concat(",")
								.concat(COLUNA_NOME)
								.concat(",")
								.concat(COLUNA_LOCALIZACAO)
								.concat(",")
								.concat(COLUNA_ENDERECO)
								.concat(" FROM ")
								.concat(super.getNomeSchemma())
								.concat(NOME_TABELA)
								.concat(" WHERE ")
								.concat(COLUNA_ID)
								.concat(" = ?");
		
		try {
			
			PreparedStatement ps = super.getPreparedStatement(sql);
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {				
				supermercados.add(new Supermercado(rs.getLong(COLUNA_ID), rs.getString(COLUNA_NOME), rs.getString(COLUNA_LOCALIZACAO), rs.getString(COLUNA_ENDERECO)));
			}
			rs.close();
			super.destroyConnection();
		} catch (SQLException e) {
			System.out.println("Erro de Consulta: " + e.getMessage());
		}
		return !supermercados.isEmpty();
	}
}
