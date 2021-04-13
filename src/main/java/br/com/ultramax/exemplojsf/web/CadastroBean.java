package br.com.ultramax.exemplojsf.web;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.bean.ManagedBean;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import br.com.ultramax.exemplojsf.main.PersistenceJPAConfig;

@ManagedBean(name = "cadastroBean")
public class CadastroBean {
	protected AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
	
	
	@PostConstruct
	public void getSpringContext() {
		ctx.register(PersistenceJPAConfig.class);
		ctx.refresh();
	}

	@PreDestroy
	public void closeSpringContext() {
		ctx.close();
	}
	
	public void listarCadastros() {
		
		
		
		
		
		
		
	}
}
