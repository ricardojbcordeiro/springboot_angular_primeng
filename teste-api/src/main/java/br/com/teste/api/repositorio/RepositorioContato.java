package br.com.teste.api.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.teste.api.model.Contato;

public interface RepositorioContato extends JpaRepository<Contato, Integer> {

	List<Contato> findByNome(String nome);
	
}
