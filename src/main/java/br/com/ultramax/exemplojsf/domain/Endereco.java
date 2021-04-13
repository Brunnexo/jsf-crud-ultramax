package br.com.ultramax.exemplojsf.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;

@Entity
public class Endereco {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String logradouro;
	
	@Column(nullable = true)
	private Integer numero;
	
	@Column(nullable = false)
	private String bairro;
	
	@Column(nullable = false)
	private String cidade;
	
	@Column(nullable = false)
	private String estado;
	
	@Column(nullable = false)
	private Integer CEP;
	
	public Long getId() {
		return this.id;
	}
	
	public String getLogradouro() {
		return this.logradouro;
	}
	
	public Integer getNumero() {
		return this.numero;
	}
	
	public String getBairro() {
		return this.bairro;
	}
	
	public String getCidade() {
		return this.cidade;
	}
	
	public String getEstado() {
		return this.estado;
	}
	public Integer getCEP() {
		return this.CEP;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	
	public void setNumero(String numero) {
		this.numero = Integer.parseInt(numero);
	}
	
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public void setCEP(Integer CEP) {
		this.CEP = CEP;
	}
	
	public void setCEP(String CEP) {
		this.CEP = Integer.parseInt(CEP);
	}
}
