package br.com.teste.api.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.teste.api.model.Endereco;
import br.com.teste.api.repositorio.RepositorioEndereco;

@Service
@Transactional
public class EnderecoService extends AbstractService<Integer, Endereco> {

	@Autowired
	private RepositorioEndereco repositorio;
	
	@Override
	public RepositorioEndereco getRepositorio() {
		return this.repositorio;
	}
	
}
