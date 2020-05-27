package br.com.teste.api.testes.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.teste.api.model.Contato;
import br.com.teste.api.service.ContatoService;

@SpringBootTest
public class ContatoServiceTest {

	@Autowired
	private ContatoService contatoService;
	
	@Test
	void salvar() throws Exception {
		Contato contato = new Contato();
		contato.setNome("Contato teste H2");
		contato.setIdade(10);
		contato.setDataCriacao(new Date());
		contatoService.salvar(contato);
		
		Contato contatoBanco = contatoService.listarTodos().get(0);
		assertNotNull(contatoBanco);
		System.out.println(contatoBanco.getId());
		assertNotNull(contatoBanco.getId());
	}
	
	@Test
	void alterar() throws Exception {
		Contato contato = new Contato();
		contato.setNome("Contato teste H2");
		contato.setIdade(10);
		contato.setDataCriacao(new Date());
		contatoService.salvar(contato);
		
		Contato contatoBanco = contatoService.listarTodos().get(0);
		Integer id = contatoBanco.getId();
		String nome = new String(contatoBanco.getNome());
		
		contatoBanco.setNome("xyz");
		contatoService.salvar(contatoBanco);
		
		Contato contatoAlterado = contatoService.porId(id).get();
		assertNotNull(contatoAlterado);
		assertNotNull(contatoAlterado.getDataAlteracao());
		assertNotEquals(nome, contatoAlterado.getNome());
		
	}
	
	@Test
	void consultaPorId() throws Exception {
		Contato contato = new Contato();
		contato.setNome("Contato teste H2");
		contato.setIdade(10);
		contato.setDataCriacao(new Date());
		contatoService.salvar(contato);
		
		Contato contatoBusca = contatoService.porId(1).get();
		assertNotNull(contatoBusca);
	}
	
}
