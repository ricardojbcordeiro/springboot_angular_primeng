package br.com.teste.api.testes.repositorio;

import static org.junit.Assert.assertNotNull;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.teste.api.model.Contato;
import br.com.teste.api.repositorio.RepositorioContato;
import br.com.teste.api.testes.DBConfig;

@SpringBootTest(classes = DBConfig.class)
public class ContatoRepositorioTest {

	@Autowired
	private RepositorioContato repositorioContato;

	@Test
	void salvar() {
		Contato contato = new Contato();
		contato.setNome("Contato teste H2");
		contato.setIdade(10);
		contato.setDataCriacao(new Date());
		repositorioContato.save(contato);

		Contato contatoBanco = repositorioContato.findByNome("Contato teste H2").get(0);
		assertNotNull(contatoBanco);
		System.out.println(contatoBanco.getId());
		assertNotNull(contatoBanco.getId());
	}

	@Test
	void atualizar() {
		Contato contato = new Contato();
		contato.setNome("Contato teste H2");
		contato.setIdade(10);
		contato.setDataCriacao(new Date());
		contato.setTamanhoImagem(new Long(7498));
		contato.setNomeImagem("vedita.jpg");
		contato.setTipoImagem("image/jpeg");
		contato.setImage64("data:image/jpeg;base64,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");
		repositorioContato.save(contato);

		Contato contatoBanco = repositorioContato.findByNome("Contato teste H2").get(0);
		assertNotNull(contatoBanco);
		System.out.println(contatoBanco.getId());
		assertNotNull(contatoBanco.getId());
	}
	
}