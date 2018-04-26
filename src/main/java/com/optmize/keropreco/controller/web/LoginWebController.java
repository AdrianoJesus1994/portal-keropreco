package com.optmize.keropreco.controller.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.optmize.keropreco.common.constants.Constantes;
import com.optmize.keropreco.controller.BaseController;
import com.optmize.keropreco.model.entity.Usuario;
import com.optmize.keropreco.model.entity.Vinho;
import com.optmize.keropreco.model.service.UsuarioService;

@Controller
@RequestMapping(Constantes.BASE_WEB_URL)
public class LoginWebController extends BaseController {
	
	@Autowired
	private UsuarioService service;
	
	@GetMapping
	public ModelAndView login(Usuario usuario) {
		ModelAndView mv = new ModelAndView("/acesso/login");
		mv.addObject("usuario", usuario);
		return mv;
	}
	
	@PostMapping("/autenticar")
	public ModelAndView login(@Valid Usuario usuario, BindingResult bindingResult, RedirectAttributes attributes) {
		if (bindingResult.hasErrors()) {
			return login(usuario);
		}
		if(getService().existe(usuario) != null) {
			return new ModelAndView("redirect:home");
		}
		
		//TODO: Adicionar dados na sessão do usuário
		
		return login(usuario);
	}
	
	
	public UsuarioService getService() {
		return service;
	}

}
