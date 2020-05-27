package br.com.teste.api.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.teste.api.model.Endereco;

public interface RepositorioEndereco extends JpaRepository<Endereco, Integer> {
	
}
