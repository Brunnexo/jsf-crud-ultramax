package br.com.ultramax.exemplojsf.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.ultramax.exemplojsf.validation.Documentos;

@Entity
public class Documento {
	// Identidade, autoincrementável
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	// Enumerável
	@Column(length = 3, nullable = false)
	@Enumerated(EnumType.STRING)
	private TipoDocumento tipoDocumento;

	// Coluna
	@Column(nullable = false)
	private String numeroDocumento;

	public void setNumeroDocumento(String documento) {
		if (documento.length() == 11 && Documentos.validarCPF(documento)) {
			this.tipoDocumento = TipoDocumento.CPF;
			this.numeroDocumento = documento;
		}
		else if (documento.length() == 11) {
			this.tipoDocumento = TipoDocumento.CNH;
			this.numeroDocumento = documento;
		}
		else {
			this.tipoDocumento = TipoDocumento.RG;
			this.numeroDocumento = documento;
		}
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public TipoDocumento getTipoDocumento() {
		return this.tipoDocumento;
	}
	
	public void setTipoDocumento(TipoDocumento tipo) {
		this.tipoDocumento = tipo;
	}
	
	public String getNumeroDocumento() {
		return this.numeroDocumento;
	}
}