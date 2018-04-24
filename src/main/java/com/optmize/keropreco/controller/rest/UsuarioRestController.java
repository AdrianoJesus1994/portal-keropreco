package com.optmize.keropreco.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.optmize.keropreco.common.constants.Constantes;
import com.optmize.keropreco.controller.BaseController;
import com.optmize.keropreco.model.entity.Usuario;
import com.optmize.keropreco.model.service.UsuarioService;

@RestController
@RequestMapping(Constantes.BASE_API_URL + "usuarios")
public class UsuarioRestController extends BaseController {
	
	@Autowired
	private UsuarioService service;
	
	@PostMapping("/existe")
	public ResponseEntity<Boolean> salvar(@RequestBody Usuario usuario) {
		if(getService().existe(usuario)) {
			return new ResponseEntity<Boolean>(Boolean.TRUE, HttpStatus.OK);
		}
		return new ResponseEntity<Boolean>(Boolean.FALSE, HttpStatus.NOT_FOUND);
	}
	
	public UsuarioService getService() {
		return service;
	}
}
