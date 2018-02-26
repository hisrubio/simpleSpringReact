package es.salesianos.service;

import java.util.List;


import es.salesianos.models.Elemento;


public interface Services {

	void insertElement(Elemento elemento);

	void updateState(Elemento elemento);
	
	List<Elemento> listElementsByState(String estado);
}
