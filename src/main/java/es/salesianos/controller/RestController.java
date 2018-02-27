package es.salesianos.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import es.salesianos.models.Elemento;
import es.salesianos.service.Services;


@org.springframework.web.bind.annotation.RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping(value = "/api/v1/element")
public class RestController {

	private static Logger log = LogManager.getLogger(RestController.class);

	@Autowired
	private Services service;
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public ResponseEntity delete(@RequestParam(required = false) String id) {
		service.delete(id);
		return new ResponseEntity(HttpStatus.OK);
	}
	
	@RequestMapping(value = "/cambiar", method = RequestMethod.GET)
	public ResponseEntity cambiar(@RequestParam(required = false) String id) {
		service.updateState("Liquido", id);
		return new ResponseEntity(HttpStatus.OK);
	}
	
	@PostMapping
	@RequestMapping(value = "/list")
	public ResponseEntity<List<Elemento>> ListAll() {
		return new ResponseEntity<>(service.listElementsByState("Solido"), HttpStatus.CREATED);
	}
	
	@PostMapping
	@RequestMapping(value = "/create")
	public ResponseEntity<Elemento> create(@RequestBody Elemento elemento) {
		service.insertElement(elemento);
		return new ResponseEntity<>(elemento, HttpStatus.CREATED);
	}
}

