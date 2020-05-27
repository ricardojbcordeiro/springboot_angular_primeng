package br.com.teste.api.repositorio.filtro;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.Predicate;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import br.com.teste.api.model.Contato;

public class FiltroContato implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<Predicate> predicates = new ArrayList<>();
	
	private Integer id;
	
	private String nome;
	
	private String cpf;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public Specification<Contato> getSpecification() {
		return (root, query, cb) -> {
			
			if(this.id != null) {
				predicates.add(cb.equal(root.get("id"), id));
			}
			
			if(!StringUtils.isEmpty(this.cpf)) {
				predicates.add(cb.equal(root.get("cpf"), this.cpf));
			}

			if(!StringUtils.isEmpty(this.nome)) {
				predicates.add(cb.like(root.get("nome"), "%" + this.nome + "%"));
			}
			
			return cb.and(predicates.toArray(new Predicate[0]));
		};
	}
	
	
	
}
