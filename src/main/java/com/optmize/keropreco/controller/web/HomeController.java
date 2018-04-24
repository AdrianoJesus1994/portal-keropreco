package com.optmize.keropreco.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.optmize.keropreco.common.constants.Constantes;
import com.optmize.keropreco.controller.BaseController;

@Controller
@RequestMapping(Constantes.BASE_WEB_URL + "home")
public class HomeController extends BaseController {
	
	@GetMapping
	public ModelAndView home() {
		return new ModelAndView("home");
	}
}
