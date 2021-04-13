package br.com.ultramax.exemplojsf.model;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.ultramax.exemplojsf.domain.Cliente;

@Service
public class ClienteService {

	@Resource
	private ClienteDAO clienteDAO;
	
	@Transactional
	public void create(Cliente cliente) {
		getClienteDao().create(cliente);
	}
	
	public void setClienteDAO(ClienteDAO clienteDAO) {
		this.clienteDAO = clienteDAO;
	}
	
	public ClienteDAO getClienteDao() {
		return clienteDAO;
	}
}
