package es.salesianos.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BaseController {

	private static Logger log = LogManager.getLogger(BaseController.class);

	@GetMapping("/")
	public ModelAndView hola() {
		log.debug("entrando a index");
		return new ModelAndView("index");
	}

}