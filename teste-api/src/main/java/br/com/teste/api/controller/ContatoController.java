package br.com.teste.api.controller;

import java.io.IOException;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
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

import br.com.teste.api.model.Contato;
import br.com.teste.api.repositorio.filtro.FiltroContato;
import br.com.teste.api.service.ContatoService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class ContatoController {

	@Autowired
	private ContatoService contatoService;
	
	private Log log = LogFactory.getLog(ContatoController.class);
	
	public ContatoService getService() {
		return contatoService;
	}
	
	@GetMapping("/contatos")
	public ResponseEntity<List<Contato>> listar() {
		List<Contato> result = this.getService().listarTodos();
		return ResponseEntity.ok(result);
	}
	
	@GetMapping("/contatos/{id}")
	public ResponseEntity<Contato> porId(@PathVariable Integer id) {
		Contato retorno = this.getService().porId(id).get();
		return ResponseEntity.ok().body(retorno);
	}
	
	@PostMapping("/contatos")
	public ResponseEntity<Contato> salvar(@RequestBody Contato contato) throws Exception {
		Contato result = this.getService().salvar(contato);
		return ResponseEntity.ok(result);
	}
	
	@PostMapping("/contatos-filtro")
	public ResponseEntity<List<Contato>> consultaFiltro(@RequestBody FiltroContato filtro) {
		List<Contato> result = this.getService().consulta(filtro);
		return ResponseEntity.ok(result);
	}
	
	@PutMapping("/contatos")
	public ResponseEntity<Contato> atualizar(@RequestBody Contato contato) throws Exception {
		Contato result = this.getService().salvar(contato);
			return ResponseEntity.ok(result);
	}
	
	@DeleteMapping("/contatos/{id}")
	public ResponseEntity<Integer> excluir(@PathVariable Integer id) {
		this.getService().excluir(id);
		return ResponseEntity.ok().body(id);
	}
	
	@GetMapping("/download/{id}")
	public ResponseEntity<Resource> downloadImage(@PathVariable Integer id) throws Exception {
		Resource resource = this.contatoService.download(id); 
		return ResponseEntity.ok()
	            .contentLength(resource.contentLength())
	            .contentType(MediaType.APPLICATION_OCTET_STREAM)
	            .body(resource);
	}
	
}
