package com.optmize.keropreco.model.repository.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.optmize.keropreco.model.entity.Usuario;
import com.optmize.keropreco.model.repository.BaseRepository;
import com.optmize.keropreco.model.repository.interfaces.UsuarioRepositoryInterface;

@Repository
public class UsuarioJDBCRepositoryImpl extends BaseRepository implements UsuarioRepositoryInterface {

	private static final String NOME_TABELA = " TB_USUARIO ";
	private static final String COLUNA_ID = "ID_USUARIO";
	private static final String COLUNA_ID_PERFIL = "ID_PERFIL";
	private static final String COLUNA_NOME = "NOME";
	private static final String COLUNA_DATA_NASCIMENTO = "DATA_NASCIMENTO";
	private static final String COLUNA_LOGIN = "LOGIN";
	private static final String COLUNA_SENHA = "SENHA";


	@Override
	public boolean existe(Usuario usuario) {

		boolean existe = false;
		String sql = "SELECT "
								.concat(COLUNA_NOME)
								.concat(",")
								.concat(COLUNA_LOGIN)
								.concat(",")
								.concat(COLUNA_ID_PERFIL)
								.concat(" FROM ")
								.concat(super.getNomeSchemma())
								.concat(NOME_TABELA)
								.concat(" WHERE ")
								.concat(COLUNA_LOGIN)
								.concat(" = ?")
								.concat(" AND ")
								.concat(COLUNA_SENHA)
								.concat(" = ?");
		
		Usuario retorno = null;

		try {

			PreparedStatement pst = super.getPreparedStatement(sql);
			pst.setString(1, usuario.getLogin());
			pst.setString(2, usuario.getSenha());

			ResultSet rs = pst.executeQuery();
			
			while (rs.next()) {
				retorno = new Usuario(rs.getString("nome"), rs.getString("login"), "");
//				if (rs.getInt("perfil") == Perfil.ADMINISTRADOR.getCodigoPerfil()) {
//					retorno.setPerfil(Perfil.ADMINISTRADOR);
//				} else {
//					retorno.setPerfil(Perfil.USUARIO);
//				}
			}
			rs.close();
			super.destroyConnection();
		} catch (SQLException e) {
			System.out.println("Erro de Consulta: " + e.getMessage());
		}

		// Caso haja um retorno na consulta com o banco de dados colocamos a variável
		// como verdadeira e retornamos
		if (retorno != null) {
			//AplicacaoUtil.getInstancia().setUsuarioLogado(retorno);
			existe = true;
		}
		return existe;
	}

}
