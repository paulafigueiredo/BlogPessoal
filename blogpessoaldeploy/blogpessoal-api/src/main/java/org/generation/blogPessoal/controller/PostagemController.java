package org.generation.blogPessoal.controller;

import java.util.List;

import org.generation.blogPessoal.model.Postagem;
import org.generation.blogPessoal.repository.PostagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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



@RestController   // informa para o spring que essa classe se trata de um controlador
@RequestMapping("/postagens") //quando vier uma requisiçao de /postagens ela avisa que e p consumir essa postagem
@CrossOrigin("*") //Qundo vier do front end,independente de onde veem ela aceita qlq origem de requisiçao
public class PostagemController {

	@Autowired
	private PostagemRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Postagem>> GetAll(){    //trazendo todas as postagens 
		return ResponseEntity.ok(repository.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Postagem> GetById(@PathVariable long id){  //trazendo as postagens por ID
		return repository.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/titulo/{titulo}")
	public ResponseEntity<List<Postagem>> GetByTitulo(@PathVariable String titulo){
		return ResponseEntity.ok(repository.findAllByTituloContainingIgnoreCase(titulo));
	}
	

	
	@PostMapping
	public ResponseEntity<Postagem> post (@RequestBody Postagem postagem){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(postagem));
	}
	
	
	@PutMapping
	public ResponseEntity<Postagem> put (@RequestBody Postagem postagem){
		return ResponseEntity.ok(repository.save(postagem));
	}
	
	@DeleteMapping("/{id}")
	public void Delete(@PathVariable long id){
		repository.deleteById(id);
	}
	
}
