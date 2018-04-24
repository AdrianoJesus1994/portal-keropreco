package com.optmize.keropreco.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public abstract class BaseController {
	
	@Autowired
	private Environment environment;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public Environment getEnvironment() {
		return environment;
	}
	
	public void setEnvironment(Environment environment) {
		this.environment = environment;
	}
	
	public Logger getLogger() {
		return logger;
	}
	
}
