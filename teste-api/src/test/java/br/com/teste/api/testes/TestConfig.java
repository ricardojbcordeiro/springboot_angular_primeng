package br.com.teste.api.testes;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.hibernate.dialect.H2Dialect;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
//@EnableJpaRepositories("br.com.teste.api.repositorio")
//@EnableTransactionManagement
public class TestConfig {

//	@Autowired
//	private Environment env;
//	
//	@Bean
//	public DataSource dataSource() {
//		HikariDataSource ds = new HikariDataSource();
//		// ds.setDataSourceProperties(dataSourceProperties());
//		ds.setAutoCommit(true);
//		ds.setUsername(env.getProperty("teste.datasource.username"));
//		ds.setPassword(env.getProperty("teste.datasource.password"));
//		ds.setDriverClassName(env.getProperty("teste.datasource.driverclassname"));
//		ds.setJdbcUrl("jdbc:h2:mem:tb_contatos;DB_CLOSE_DELAY=-1;INIT=CREATE SCHEMA IF NOT EXISTS dbo\\;SET SCHEMA dbo");
//		return ds;
//	}
//	
//	@Bean
//	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
//		LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
//		emf.setDataSource(dataSource());
//		emf.setPersistenceUnitName("unit_testes");
//		emf.setPackagesToScan("br.com.teste.api.model");
//		emf.setPersistenceProviderClass(HibernatePersistenceProvider.class);
//		emf.setJpaProperties(dataSourceProperties());
//		
//		return emf;
//	}
//	
//	public Properties dataSourceProperties() {
//		Properties prop = new Properties();
//		prop.setProperty("driverClassName", env.getProperty("teste.datasource.driverclassname"));
//		prop.setProperty("url", env.getProperty("teste.datasource.url"));
//		prop.setProperty("username", env.getProperty("teste.datasource.username"));
//		prop.setProperty("password", env.getProperty("teste.datasource.password"));
//		prop.setProperty("hibernate.dialect", env.getProperty("teste.hibernate.dialect"));
//		prop.setProperty("hibernate.ddl-auto", env.getProperty("teste.hibernate.ddl-auto"));
//		prop.setProperty("hibernate.show-sql", "true");
//		prop.setProperty("hbm2ddl.auto", "create");
//		prop.setProperty("jpa.hibernate.ddl-auto", "create");
//		return prop;
//	}
	
	
	
}
