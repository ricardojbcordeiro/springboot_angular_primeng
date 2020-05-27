package br.com.teste.api.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories("br.com.teste.api.repositorio")
@EnableTransactionManagement
public class DataBaseConfig {

}
