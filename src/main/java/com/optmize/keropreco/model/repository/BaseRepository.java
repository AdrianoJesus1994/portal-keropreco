package com.optmize.keropreco.model.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public abstract class BaseRepository {

	@Autowired
	private Environment env;
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private Connection con = null;
	
    private String nomeSchemma = "";
    private String user = "";
    private String pws = "";
    private String driver = "";
    private String url = "";
  
    @PostConstruct
   	public void init() {
    	this.user = getEnv().getProperty("spring.datasource.username");
    	this.pws = getEnv().getProperty("spring.datasource.password");
    	this.driver = getEnv().getProperty("spring.datasource.driver-class-name");
    	this.url = getEnv().getProperty("spring.datasource.url");
    }
    
    public Statement getStatement() throws SQLException {
        return this.startConnection().createStatement();
    }
    
    public PreparedStatement getPreparedStatement(String sql) throws SQLException {
        return this.startConnection().prepareStatement(sql);
    }
    
    private Connection startConnection() {
        try {
            if(this.con == null){
                Class.forName(driver);
                con = DriverManager.getConnection(url, user, pws);
            }
        } catch (ClassNotFoundException cnfex) {
            this.logger.error("Erro de driver", cnfex);
        } catch (SQLException sqlex){
        	this.logger.error("Erro SQL", sqlex);
        } catch(Exception e){
        	this.logger.error("Erro Geral", e);
        }        
        return con;
    }
    
    public void destroyConnection(){
        try {
            if(this.con != null){
                con.close();
                this.con = null;
            }
        } catch (SQLException e) {
        	this.logger.error("Erro Ao Fechar A Conexão", e);
        }
    }

    public String getNomeSchemma() {
        return nomeSchemma;
    }
    
    public Environment getEnv() {
		return env;
	}
    
    public void setEnv(Environment env) {
		this.env = env;
	}
}
