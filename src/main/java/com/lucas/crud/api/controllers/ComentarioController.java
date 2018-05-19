package com.lucas.crud.api.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lucas.crud.api.documents.Comentario;
import com.lucas.crud.api.responses.Response;
import com.lucas.crud.api.services.ComentarioService;

@RestController
@RequestMapping(path="/api/comentarios")
public class ComentarioController {
	
	@Autowired
	private ComentarioService comentarioService;
	
	@GetMapping
	public ResponseEntity<Response<List<Comentario>>> listarTodos(){
		return ResponseEntity.ok(new Response<List<Comentario>>(comentarioService.listarTodos()));
	}
	
	@GetMapping(path="/{id}")
	public ResponseEntity<Response<Comentario>> listarPorId(@PathVariable(name = "id") String id){
		return ResponseEntity.ok(new Response<Comentario>(this.comentarioService.buscarPorId(id)));
	} 
	
	@PostMapping
	public ResponseEntity<Response<Comentario>> cadastrar(@Valid @RequestBody Comentario comentario, BindingResult result){
		if(result.hasErrors()) {
			List<String> erros = new ArrayList<String>();
			result.getAllErrors().forEach(erro -> erros.add(erro.getDefaultMessage()));
			return ResponseEntity.badRequest().body(new Response<Comentario>(erros));
		}
		return ResponseEntity.ok(new Response<Comentario>(this.comentarioService.cadastrar(comentario)));
	}
	
	@PutMapping
	public ResponseEntity<Response<Comentario>> atualizar(@PathVariable(name = "id") String id ,@Valid @RequestBody Comentario comentario, BindingResult result){
		if(result.hasErrors()) {
			List<String> erros = new ArrayList<String>();
			result.getAllErrors().forEach(erro -> erros.add(erro.getDefaultMessage()));
			return ResponseEntity.badRequest().body(new Response<Comentario>(erros));
		}
		comentario.setId(id);
		return ResponseEntity.ok(new Response<Comentario>(this.comentarioService.atualizar(comentario)));
	}
	
	@DeleteMapping(path="/{id}")
	public ResponseEntity<Response<String>> remover(@PathVariable(name = "id") String id){
		this.comentarioService.remover(id);
		return ResponseEntity.ok(new Response<String>("Comentario Removido com sucesso !"));
	}
	
	
}
