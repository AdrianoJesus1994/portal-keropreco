package com.optmize.keropreco.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.optmize.keropreco.common.constants.Constantes;
import com.optmize.keropreco.controller.BaseController;
import com.optmize.keropreco.model.entity.Supermercado;
import com.optmize.keropreco.model.service.SupermercadoService;

@RestController
@RequestMapping(Constantes.BASE_API_URL + "supermercados")
public class SupermercadoRestController extends BaseController {

	@Autowired
	private SupermercadoService service;
	
	@GetMapping
	public List<Supermercado> listar() {
		return getService().listarTodos();
	}
	
	@PostMapping
	public ResponseEntity<Supermercado> salvar(@RequestBody Supermercado Supermercado) {
		if(getService().salvar(Supermercado)) {
			return new ResponseEntity<Supermercado>(HttpStatus.CREATED);
		}
		return new ResponseEntity<Supermercado>(HttpStatus.BAD_REQUEST);
	}
	
	@PutMapping
	public ResponseEntity<Supermercado> alterar(@RequestBody Supermercado Supermercado) {
		if(getService().editar(Supermercado)) {
			return new ResponseEntity<Supermercado>(HttpStatus.OK);
		}
		return new ResponseEntity<Supermercado>(HttpStatus.BAD_REQUEST);
	}
	 
	@DeleteMapping("{id}")
	public ResponseEntity<Supermercado> remover(@PathVariable Long id) {
		if(getService().remover(id)) {
			return new ResponseEntity<Supermercado>(HttpStatus.OK);
		}
		return new ResponseEntity<Supermercado>(HttpStatus.BAD_REQUEST);
	}
	
	public SupermercadoService getService() {
		return service;
	}
	
}
