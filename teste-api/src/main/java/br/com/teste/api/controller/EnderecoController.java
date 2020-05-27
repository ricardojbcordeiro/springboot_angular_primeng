package br.com.teste.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.teste.api.model.Endereco;
import br.com.teste.api.service.EnderecoService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class EnderecoController {

	@Autowired
	private EnderecoService service;
	
	public EnderecoService getService() {
		return service;
	}
	
	@GetMapping("/enderecos")
	public ResponseEntity<List<Endereco>> listar() {
		List<Endereco> result = this.getService().listarTodos();
		return ResponseEntity.ok(result);
	}
	
	@GetMapping("/enderecos/{id}")
	public ResponseEntity<Endereco> porId(@PathVariable Integer id) {
		Endereco retorno = this.getService().porId(id).get();
		return ResponseEntity.ok().body(retorno);
	}
	
	@PostMapping("/enderecos")
	public ResponseEntity<Endereco> salvar(@RequestBody Endereco Endereco) throws Exception {
		Endereco result = this.getService().salvar(Endereco);
		return ResponseEntity.ok(result);
	}
	
	@PutMapping("/Enderecos")
	public void atualizar(@RequestBody Endereco Endereco) throws Exception {
		this.getService().salvar(Endereco);
	}
	
	@DeleteMapping("/Enderecos/{id}")
	public ResponseEntity<Integer> excluir(@PathVariable Integer id) {
		this.getService().excluir(id);
		return ResponseEntity.ok().body(id);
	}
	
}
