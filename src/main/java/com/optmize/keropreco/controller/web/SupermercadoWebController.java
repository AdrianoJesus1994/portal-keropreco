package com.optmize.keropreco.controller.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.optmize.keropreco.model.entity.TipoVinho;
import com.optmize.keropreco.common.constants.Constantes;
import com.optmize.keropreco.model.entity.Supermercado;
import com.optmize.keropreco.model.service.SupermercadoService;

@Controller
@RequestMapping(Constantes.BASE_WEB_URL + "supermercados")
public class SupermercadoWebController {
	
	@Autowired
	private SupermercadoService service;
	
	@GetMapping("/editar/{id}")
	public ModelAndView editar(@PathVariable Long id) {
		ModelAndView mv = new ModelAndView("supermercados/editar-supermercado");
		mv.addObject("supermercado", getService().buscarPorId(id));
		mv.addObject("tipos", TipoVinho.values());	
		return mv;
	}
	
	@GetMapping("/novo")
	public ModelAndView novo(Supermercado supermercado) {
		ModelAndView mv = new ModelAndView("supermercados/cadastro-supermercado");
		mv.addObject("supermercado", supermercado);
		mv.addObject("tipos", TipoVinho.values());	
		return mv;
	}
	
	@GetMapping("/listar")
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView("supermercados/lista-supermercados");
		mv.addObject("supermercados", getService().listarTodos());	
		return mv;
	}
	
	@PostMapping("/inserir")
	public ModelAndView inserir(@Valid Supermercado supermercado, BindingResult bindingResult, RedirectAttributes attributes) {
		if (bindingResult.hasErrors()) {
			return novo(supermercado);
		}
		if(getService().salvar(supermercado)) {
			attributes.addFlashAttribute("messageSuccess", "Supermercado salvo com sucesso!");	
			return new ModelAndView("redirect:/supermercados/listar");
		}
		return novo(supermercado);
	}
	
	@PutMapping("/editar")
	public ModelAndView editar(@Valid Supermercado supermercado, BindingResult bindingResult, RedirectAttributes attributes) {
		if (bindingResult.hasErrors()) {
			return editar(supermercado.getIdSupermercado());
		}
		if(getService().editar(supermercado)) {
			attributes.addFlashAttribute("messageSuccess", "Supermercado editado com sucesso!");	
			return new ModelAndView("redirect:/supermercados/listar");
		}
		return editar(supermercado.getIdSupermercado());
	}
	
	@DeleteMapping("/remover/{id}")
	public String remover(@PathVariable Long id, RedirectAttributes attributes) {
		if(getService().remover(id)) {
			attributes.addFlashAttribute("messageSuccess", "Supermercado removido com sucesso!");
		}
		return "redirect:/supermercados/listar";
	}
	
	public SupermercadoService getService() {
		return service;
	}
}
