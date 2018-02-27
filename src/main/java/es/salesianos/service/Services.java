package es.salesianos.service;

import java.util.List;


import es.salesianos.models.Elemento;


public interface Services {

	void insertElement(Elemento elemento);

	void updateState(String estado,String id);
	
	void delete(String id);

	List<Elemento> listElementsByState(String estado);
}
