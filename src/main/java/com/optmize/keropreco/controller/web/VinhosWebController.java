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

import com.optmize.keropreco.common.constants.Constantes;
import com.optmize.keropreco.controller.BaseController;
import com.optmize.keropreco.model.entity.TipoVinho;
import com.optmize.keropreco.model.entity.Vinho;
import com.optmize.keropreco.model.service.VinhoService;

@Controller
@RequestMapping(Constantes.BASE_WEB_URL + "vinhos")
public class VinhosWebController extends BaseController {
	
	@Autowired
	private VinhoService service;
	
	@GetMapping("/editar/{id}")
	public ModelAndView editar(@PathVariable Long id) {
		ModelAndView mv = new ModelAndView("vinhos/editar-vinho");
		mv.addObject("vinho", getService().buscarPorId(id));
		mv.addObject("tipos", TipoVinho.values());	
		return mv;
	}
	
	@GetMapping("/novo")
	public ModelAndView novo(Vinho vinho) {
		ModelAndView mv = new ModelAndView("vinhos/cadastro-vinho");
		mv.addObject("vinho", vinho);
		mv.addObject("tipos", TipoVinho.values());	
		return mv;
	}
	
	@GetMapping("/listar")
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView("vinhos/lista-vinhos");
		mv.addObject("vinhos", getService().listarTodos());	
		return mv;
	}
	
	@PostMapping("/inserir")
	public ModelAndView inserir(@Valid Vinho vinho, BindingResult bindingResult, RedirectAttributes attributes) {
		if (bindingResult.hasErrors()) {
			return novo(vinho);
		}
		getService().salvar(vinho);
		attributes.addFlashAttribute("messageSuccess", "Vinho salvo com sucesso!");	
		return new ModelAndView("redirect:/vinhos/listar");
	}
	
	@PutMapping("/editar")
	public ModelAndView editar(@Valid Vinho vinho, BindingResult bindingResult, RedirectAttributes attributes) {
		if (bindingResult.hasErrors()) {
			return editar(vinho.getId());
		}
		getService().editar(vinho);
		attributes.addFlashAttribute("messageSuccess", "Vinho editado com sucesso!");	
		return new ModelAndView("redirect:/vinhos/listar");
	}
	
	@DeleteMapping("/remover/{id}")
	public String remover(@PathVariable Long id, RedirectAttributes attributes) {
		getService().remover(id);
		attributes.addFlashAttribute("messageSuccess", "Vinho removido com sucesso!");
		return "redirect:/vinhos/listar";
	}
	
	public VinhoService getService() {
		return service;
	}
	
	public void setService(VinhoService service) {
		this.service = service;
	}
}
