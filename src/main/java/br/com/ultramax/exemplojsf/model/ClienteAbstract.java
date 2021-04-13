package br.com.ultramax.exemplojsf.model;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.transaction.annotation.Propagation;

import br.com.ultramax.exemplojsf.domain.Cliente;

public abstract class ClienteAbstract {
	
	@Transactional(propagation = Propagation.REQUIRED)
	public void create(Cliente cliente) {
		
	}
	
	public void update(Cliente cliente) {
	}
	
	public Cliente find(Long id) {
		return null;
	}
	public Cliente find(String hQuery) {
		return null;
	}
	
	public void delete(Cliente cliente) {
	}
}
