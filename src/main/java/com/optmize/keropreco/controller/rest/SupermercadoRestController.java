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
import com.optmize.keropreco.model.service.SupermercadosService;

@RestController
@RequestMapping(Constantes.BASE_API_URL + "supermercados")
public class SupermercadoRestController extends BaseController {

	@Autowired
	private SupermercadosService service;
	
	@GetMapping
	public List<Supermercado> listar() {
		return getService().listarTodos();
	}
	
	@PostMapping
	public Supermercado salvar(@RequestBody Supermercado Supermercado) {
		return getService().salvar(Supermercado);
	}
	
	@PutMapping
	public ResponseEntity<Supermercado> alterar(@RequestBody Supermercado Supermercado) {
		Supermercado retorno = getService().editar(Supermercado);
		if(retorno == null) {
			return new ResponseEntity<Supermercado>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Supermercado>(retorno, HttpStatus.OK);
	}
	 
	@DeleteMapping("{id}")
	public void remover(@PathVariable Long id) {
		getService().remover(id);
	}
	
	public SupermercadosService getService() {
		return service;
	}
	
}
