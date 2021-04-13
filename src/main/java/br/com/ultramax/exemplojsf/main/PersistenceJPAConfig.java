package br.com.ultramax.exemplojsf.main;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = "br.com.ultramax.exemplojsf")
@EnableJpaRepositories(basePackages = {"br.com.ultramax.exemplojsf"}, entityManagerFactoryRef = "dbEntityManager", transactionManagerRef = "transactionManager")
@EnableTransactionManagement
public class PersistenceJPAConfig {
	@Bean
	public EntityManagerFactory entityManagerFactoryBean() {
		return Persistence.createEntityManagerFactory("em-mssql");
	}

	@Bean(name="transactionManager")
	public PlatformTransactionManager transactionManager() {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactoryBean());
		return transactionManager;
	}
}