package es.salesianos.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import es.salesianos.models.Elemento;
import es.salesianos.repository.ElementoRepository;

@Service
public class ElementService implements es.salesianos.service.Services {

	private static Logger log = LogManager.getLogger(ElementService.class);

	@Autowired
	private ElementoRepository repository;

	@Override
	public void insertElement(Elemento elemento) {
		repository.insert(elemento);
	}

	@Override
	public void updateState(Elemento elemento) {
		repository.updateState(elemento);
	}
	
	@Override
	public List<Elemento> listElementsByState(String estado) {
		return repository.listElementsByState(estado);
	}
	
	public ElementoRepository getRepository() {
		return repository;
	}
	public void setRepository(ElementoRepository repository) {
		this.repository = repository;
	}
}
