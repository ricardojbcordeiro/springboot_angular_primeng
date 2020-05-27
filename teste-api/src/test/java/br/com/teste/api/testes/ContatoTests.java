package br.com.teste.api.testes;

import static org.junit.Assert.assertNotNull;

import java.util.Date;

import org.junit.jupiter.api.Test;

import br.com.teste.api.model.Contato;

public class ContatoTests {

	@Test
	public void testContato() {
		Contato contato = new Contato();
		contato.setId(1);
		contato.setDataAlteracao(new Date());
		contato.setDataCriacao(new Date());
		contato.setEndereco("endereco");
		contato.setIdade(10);
		contato.setNome("Nome Contato");
		assertNotNull(contato.getId());
		assertNotNull(contato.getDataAlteracao());
		assertNotNull(contato.getDataCriacao());
		assertNotNull(contato.getEndereco());
	}
	
}
