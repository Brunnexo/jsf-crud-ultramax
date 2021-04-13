package testespring;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import br.com.ultramax.exemplojsf.domain.Cliente;
import br.com.ultramax.exemplojsf.domain.Contato;
import br.com.ultramax.exemplojsf.domain.Documento;
import br.com.ultramax.exemplojsf.domain.Endereco;
import br.com.ultramax.exemplojsf.main.PersistenceJPAConfig;
import br.com.ultramax.exemplojsf.model.ClienteService;

public class TesteSpring {

	public static void main(String[] args) {
		Logger logger = Logger.getLogger("testespring");

		// ApplicationContext ctx = new
		// ClassPathXmlApplicationContext("META-INF/beans.xml");
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.register(PersistenceJPAConfig.class);
		ctx.refresh();

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

		ClienteService clienteService = (ClienteService) ctx.getBean("clienteService");

		clienteService.create(cliente);

		ctx.close();
	}

}
