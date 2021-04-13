package br.com.ultramax.exemplojsf.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.ultramax.exemplojsf.validation.Contatos;

@Entity
public class Contato {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	// Enumerado, evita problemas de entrada
	@Enumerated(EnumType.STRING)
	@Column(length = 150, nullable = false)
	private TipoContato tipoContato;
	
	@Column(length = 150, nullable = false)
	private String contato;

	public Long getId() {
		return id;
	}

	public TipoContato getTipoContato() {
		return this.tipoContato;
	}
	
	public String getContato() {
		return this.contato;
	}
	
	public void setContato(String contato) {
		if (Contatos.validarTelefone(contato)) {
			this.tipoContato = TipoContato.TELEFONE;
			this.contato = contato;
		} else if(Contatos.validarEmail(contato)) {
			this.tipoContato = TipoContato.EMAIL;
			this.contato = contato;
		}
	}
}