package testehibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import br.com.ultramax.exemplojsf.domain.Cliente;
import br.com.ultramax.exemplojsf.domain.Documento;

public class TesteHibernateMerge {

	public static void main(String[] args) {
		// Factory do EntityManager (em-mssql)
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("em-mssql");
		
		// Cria EntityManager
		EntityManager em = emf.createEntityManager();
		
		// Objeto de transação
		EntityTransaction et = em.getTransaction();
		
		// Obtém o cliente do banco de dados
		Cliente c = em.find(Cliente.class, 1L);
		
		// Cria o RG
		Documento RG = new Documento();
		
		// Insere o número do documento e automaticamente define o tipo
		RG.setNumeroDocumento("496841762");
		
		//Testa tipo de documento
		System.out.println("Tipo de documento: " + RG.getTipoDocumento());
		
		c.getDocumentos().add(RG);
		
		// Inicia transação
		et.begin();
		
		// Merge (update) na DB
		em.merge(c);
		
		// Confirma transação
		et.commit();
	}
}
