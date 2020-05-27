package br.com.teste.api.repositorio;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import br.com.teste.api.model.Contato;

public interface RepositorioContatoSpecification extends CrudRepository<Contato, Integer>, JpaSpecificationExecutor<Contato> {

}
