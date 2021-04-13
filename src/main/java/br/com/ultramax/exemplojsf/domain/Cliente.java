package br.com.ultramax.exemplojsf.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Cliente {
	// Um cliente pode ter vários contatos
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Contato> contatos;

	// Um cliente pode ter vários documentos
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Documento> documentos;
	
	// Um cliente pode ter apenas um endereço
	@OneToOne(cascade = CascadeType.ALL)
	private Endereco endereco;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 150, nullable = false)
	private String nome;

	public List<Contato> getContatos() {
		return this.contatos;
	}

	public List<Documento> getDocumentos() {
		return this.documentos;
	}
	
	public Long getId() {
		return this.id;
	}

	public String getNome() {
		return this.nome;
	}
	
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	public Endereco getEndereco() {
		return this.endereco;
	}

	public void setContatos(List<Contato> contatos) {
		this.contatos = contatos;
	}
	
	public void setDocumentos(List<Documento> documentos) {
		this.documentos = documentos;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}