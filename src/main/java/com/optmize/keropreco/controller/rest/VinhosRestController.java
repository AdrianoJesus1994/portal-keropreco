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
import com.optmize.keropreco.model.entity.Usuario;
import com.optmize.keropreco.model.entity.Vinho;
import com.optmize.keropreco.model.repository.impl.UsuarioJDBCRepositoryImpl;
import com.optmize.keropreco.model.service.VinhoService;

@RestController
@RequestMapping(Constantes.BASE_API_URL + "vinhos")
public class VinhosRestController extends BaseController {
	
	@Autowired
	private VinhoService service;
	
	@Autowired
	private UsuarioJDBCRepositoryImpl repo;
	

	@GetMapping
	public List<Vinho> listar() {
		return getService().listarTodos();
	}
	
	@PostMapping
	public Vinho salvar(@RequestBody Vinho vinho) {
		return getService().salvar(vinho);
	}
	
	@PutMapping
	public ResponseEntity<Vinho> alterar(@RequestBody Vinho vinho) {
		Vinho retorno = getService().editar(vinho);
		if(retorno == null) {
			return new ResponseEntity<Vinho>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Vinho>(retorno, HttpStatus.OK);
	}
	 
	@DeleteMapping("{id}")
	public void remover(@PathVariable Long id) {
		getService().remover(id);
	}
	
	public VinhoService getService() {
		return service;
	}
	

}
