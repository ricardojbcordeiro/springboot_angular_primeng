package br.com.teste.api.testes.api;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.teste.api.model.Contato;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class TestApiContato {

	@LocalServerPort
	private int port;

	MockMvc mockMvc;

	@Autowired
	private TestRestTemplate restTemplate;

	@BeforeEach
	void setup(WebApplicationContext wac) {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}

	private String getResourceUrl() {
		return "http://localhost:" + this.port + "/api/v1/contatos";
	}

	@Test
	void getContato() throws Exception {
//		this.mockMvc
//			.perform(get("/api/v1/contatos/7")
//				.accept(MediaType.APPLICATION_JSON))
//			.andExpect(status().isOk())
//			.andExpect(content().contentType("application/json"))
//			.andExpect(jsonPath("$.nome").value("a"));

	}

	@Test
	void postContato() {
		try {
			Contato contato = new Contato();
			contato.setNome("teste post");
			contato.setIdade(12);
			contato.setDataCriacao(new Date());

//		ResponseEntity<Contato> contatoSalvo = this.restTemplate.postForEntity(this.getResourceUrl(), contato, Contato.class);
//		assertNotNull(contatoSalvo);
//		assertNotNull(contatoSalvo.getBody());
//		System.out.println("salvo salvo salvo salvo");
//		System.out.println(contatoSalvo.getBody().getId());
			
			this.mockMvc.perform(post("/api/v1/contatos")
	                .content(asJsonString(contato))
	                .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
	                .andExpect(status().isOk())
	                .andExpect(content().contentType("application/json"))
	                .andExpect(jsonPath("$.id").value(1));
			
			System.out.println("ok");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}