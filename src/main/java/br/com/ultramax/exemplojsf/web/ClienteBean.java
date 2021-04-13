package br.com.ultramax.exemplojsf.web;

import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import br.com.ultramax.exemplojsf.domain.Cliente;
import br.com.ultramax.exemplojsf.domain.Contato;
import br.com.ultramax.exemplojsf.domain.Documento;
import br.com.ultramax.exemplojsf.domain.Endereco;
import br.com.ultramax.exemplojsf.main.PersistenceJPAConfig;
import br.com.ultramax.exemplojsf.model.ClienteService;

@ManagedBean(name = "clienteBean")
@ViewScoped
public class ClienteBean {
	protected AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
	public Logger logger = Logger.getLogger(ClienteBean.class);

	protected Cliente cliente = new Cliente();
	protected Endereco endereco = new Endereco();

	protected Documento documento = new Documento();
	protected ArrayList<Documento> documentos = new ArrayList<Documento>();

	protected Contato contato = new Contato();
	protected ArrayList<Contato> contatos = new ArrayList<Contato>();

	private String nome;
	private String contat;
	private String doc;
	
	private boolean mostrarMensagem = false;

	private String mensagem;

	private String logradouro;
	private String numero;
	private String bairro;
	private String cidade;
	private String estado;
	private String cep;

	private ArrayList<String> nomesDocumentos = new ArrayList<String>();
	private ArrayList<String> nomesContatos = new ArrayList<String>();

	@PostConstruct
	public void getSpringContext() {
		ctx.register(PersistenceJPAConfig.class);
		ctx.refresh();
	}

	@PreDestroy
	public void closeSpringContext() {
		ctx.close();
	}

	public String salvar() {
		// Salvar endereço
		endereco.setLogradouro(logradouro);
		endereco.setNumero(numero);
		endereco.setBairro(bairro);
		endereco.setCidade(cidade);
		endereco.setEstado(estado);
		endereco.setCEP(cep);

		// Construção do cliente
		logger.info("Adicionando nome do cliente [" + nome + "]...");
		cliente.setNome(nome);
		logger.info("Adicionando documentos [" + documentos.size() + "]...");
		cliente.setDocumentos(documentos);
		logger.info("Adicionando endereço [" + endereco.getCEP() + "]...");
		cliente.setEndereco(endereco);
		logger.info("Adicionando contatos [" + contatos.size() + "]...");
		cliente.setContatos(contatos);

		// Spring - DB
		logger.info("Inserindo cliente ao banco de dados...");
		try {
			((ClienteService) ctx.getBean("clienteService")).create(cliente);
			this.mensagem = nome + " cadastrado!";
			this.mostrarMensagem = true;
		} catch (Exception e) {
			this.mensagem = "Problema ao cadastrar cliente!";
			this.mostrarMensagem = true;
			logger.error(e.getMessage());
		}
		return "";
	}

	public String addDocumento() {
		documento.setNumeroDocumento(doc);
		documentos.add(documento);
		nomesDocumentos.add(documento.getTipoDocumento() + ": " + documento.getNumeroDocumento());
		return "";
	}

	public String clearDocumento() {
		documentos.clear();
		nomesDocumentos.clear();
		return "";
	}

	public String addContato() {
		contato.setContato(contat);
		contatos.add(contato);
		nomesContatos.add(contato.getTipoContato() + ": " + contato.getContato());
		return "";
	}

	public String clearContato() {
		contatos.clear();
		nomesContatos.clear();
		return "";
	}

	public String getNome() {
		return nome;
	}

	public String getContat() {
		return contat;
	}

	public String getDoc() {
		return doc;
	}

	public String getMensagem() {
		return mensagem;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public String getBairro() {
		return bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public String getEstado() {
		return estado;
	}

	public String getCep() {
		return cep;
	}

	public boolean isMostrarMensagem() {
		return mostrarMensagem;
	}

	public void setMostrarMensagem(boolean mostrarMensagem) {
		this.mostrarMensagem = mostrarMensagem;
	}
	
	public ArrayList<String> getNomesDocumentos() {
		return nomesDocumentos;
	}

	public ArrayList<String> getNomesContatos() {
		return nomesContatos;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setContat(String contat) {
		this.contat = contat;
	}

	public void setDoc(String doc) {
		this.doc = doc;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public void setNumero(String numero) {
		this.numero = numero;
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

	public void setCep(String cep) {
		this.cep = cep;
	}

	public void setNomesDocumentos(ArrayList<String> nomesDocumentos) {
		this.nomesDocumentos = nomesDocumentos;
	}

	public void setNomesContatos(ArrayList<String> nomesContatos) {
		this.nomesContatos = nomesContatos;
	}
}
