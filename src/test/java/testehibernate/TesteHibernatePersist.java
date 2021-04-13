package testehibernate;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.apache.log4j.Logger;

import br.com.ultramax.exemplojsf.domain.Cliente;
import br.com.ultramax.exemplojsf.domain.Contato;
import br.com.ultramax.exemplojsf.domain.Documento;
import br.com.ultramax.exemplojsf.domain.Endereco;

public class TesteHibernatePersist {
	public static void main (String[] args) {
		Logger logger = Logger.getLogger("TesteHibernate");
		
		Cliente cliente = new Cliente();
		
		// Nome do cliente
		cliente.setNome("Bruno Costa");
		
		// Instancia lista de contatos
		List<Contato> contatos = new ArrayList<Contato>();
		
		// Cria um novo contato
		Contato telefone = new Contato();
		
		// Automaticamente define o tipo de contato pelo valor dado
		telefone.setContato("945660620");
		
		// Testa tipo de contato
		logger.info("Tipo de contato: " + telefone.getTipoContato());
		
		// Adiciona aos contatos do cliente
		contatos.add(telefone);
		cliente.setContatos(contatos);
		
		// Instancia lista de documentos
		List<Documento> documentos = new ArrayList<Documento>();
		
		// Cria um documento
		Documento cpf = new Documento();
		
		// Automaticamente define o tipo de documento pelo valor dado
		cpf.setNumeroDocumento("46055389843");
		
		// Testa tipo de documento
		logger.info("Tipo de documento: " + cpf.getTipoDocumento());
		
		// Adiciona aos documentos do cliente
		documentos.add(cpf);
		cliente.setDocumentos(documentos);
		
		
		// Cria endereço
		Endereco endereco = new Endereco();
		endereco.setLogradouro("Rua Nestor Chagas");
		endereco.setNumero(284);
		endereco.setBairro("Jardim das Tulipas");
		endereco.setCidade("Jundiaí");
		endereco.setEstado("São Paulo");
		endereco.setCEP(13212720);
		
		// Adiciona endereco ao cliente
		cliente.setEndereco(endereco);
		
		// Factory do EntityManager (em-mssql)
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("em-mssql");
		
		// Cria EntityManager
		EntityManager em = emf.createEntityManager();
		
		// Objeto de transação
		EntityTransaction et = em.getTransaction();

		// Inicia transação
		et.begin();
		
		// Persisir em DB
		em.persist(cliente);
		
		// Confirma transação
		et.commit();
		
		// Fecha o EntityManager e o Factory
		em.close();
		emf.close();
	}
}
