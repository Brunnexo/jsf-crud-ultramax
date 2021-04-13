package br.com.ultramax.exemplojsf.model;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.Resource;
import javax.persistence.EntityManager;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.ultramax.exemplojsf.domain.Cliente;

@Service
@Scope("prototype")
public class ClienteDAO {
	
	@Resource
	private EntityManager entityManager;
	
	@Transactional(rollbackFor = SQLException.class)
	public void create(Cliente cliente) {
		entityManager.persist(cliente);
	}

	@Transactional(rollbackFor = SQLException.class)
	public void update(Cliente cliente) {
		entityManager.merge(cliente);
	}

	@Transactional(readOnly = true)
	public Cliente find(Long id) {
		return (Cliente) entityManager.find(Cliente.class, id);
	}
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public ArrayList<Cliente> findList(String hQuery) {
		return (ArrayList<Cliente>) entityManager.createQuery(hQuery).getResultList();
	}
	
	@Transactional(rollbackFor = SQLException.class)
	public void delete(Cliente cliente) {
		entityManager.remove(cliente);
	}
	
	@Transactional(rollbackFor = SQLException.class)
	public void delete(String hQuery) {
		Cliente tempCliente = (Cliente) entityManager.createQuery(hQuery).getSingleResult();
		entityManager.remove(tempCliente);
	}
}