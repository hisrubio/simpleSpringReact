package es.salesianos.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import es.salesianos.models.Elemento;
import es.salesianos.service.Services;


@Controller
public class PruebaController {

	private static Logger log = LogManager.getLogger(PruebaController.class);

	@Autowired
	private Services service;
	
	@GetMapping("/Cooking")
	public ModelAndView ver() {
		log.debug("entrando a insertar nuevo tipo de cocina");
		ModelAndView modelAndView = new ModelAndView("pollas", "command", new Elemento());
		modelAndView.addObject("listado", service.listElementsByState("Solido"));
		modelAndView.addObject("listado2", service.listElementsByState("Liquido"));
		return modelAndView;
	}

	@PostMapping("/cookings")
	public ModelAndView create(@ModelAttribute("elemento") Elemento elemento) {
		log.debug("inserting cookingType");
		service.insertElement(elemento);
		//return new ModelAndView("pollas", "command", new Elemento());
		
		//para que te liste tambien cuando estas insertando
		ModelAndView modelAndView = new ModelAndView("pollas", "command", new Elemento());
		modelAndView.addObject("listado", service.listElementsByState("Solido"));
		modelAndView.addObject("listado2", service.listElementsByState("Liquido"));
		return modelAndView;
	}

}

