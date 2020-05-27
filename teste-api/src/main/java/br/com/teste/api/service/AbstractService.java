package br.com.teste.api.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.teste.api.model.AbstractModel;

abstract public class AbstractService<ID, M extends AbstractModel<ID> > {
	
	abstract public JpaRepository<M, ID> getRepositorio();
	
	public List<M> listarTodos(){
		return this.getRepositorio().findAll();
	}
	
	public void validarCamposObrigatorios(M model) throws Exception {}
	public void validarCamposUnitarios(M model) throws Exception {}
	
	public M salvar(M model) throws Exception {
		this.validarCamposObrigatorios(model);
		this.validarCamposUnitarios(model);
		if(model.getId() == null) {
			model.setDataCriacao(new Date());
		} else {
			model.setDataAlteracao(new Date());
		}
		return this.getRepositorio().save(model);
	}
	
	public void excluir(ID id) {
		M model = this.porId(id).get();
		this.getRepositorio().delete(model);
	}
	
	public Optional<M> porId(ID id) {
		return this.getRepositorio().findById(id);
	}
	
}
