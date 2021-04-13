package testehibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.ultramax.exemplojsf.domain.Cliente;

public class TesteHibernateFind {
	public static void main(String[] args) {
		// Factory do EntityManager (em-mssql)
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("em-mssql");

		// Cria EntityManager
		EntityManager em = emf.createEntityManager();

		Cliente c = em.find(Cliente.class, 1L);
		
		System.out.println("Nome do cliente: " + c.getNome());
		System.out.println("Endereço: " + c.getEndereco().getLogradouro()
										+ ", " + c.getEndereco().getNumero()
										+ ", " + c.getEndereco().getBairro());
		System.out.println("Cidade: " + c.getEndereco().getCidade() + " - " + c.getEndereco().getEstado());
		System.out.println("Documentos:");
		
		for (int i = 0; i < c.getDocumentos().size(); i++) {
			System.out.println(c.getDocumentos().get(i).getTipoDocumento()
					+ ": " + c.getDocumentos().get(i).getNumeroDocumento());
		}
	}
}
