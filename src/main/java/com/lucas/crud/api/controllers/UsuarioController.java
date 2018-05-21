package com.lucas.crud.api.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lucas.crud.api.documents.Usuario;
import com.lucas.crud.api.responses.Response;
import com.lucas.crud.api.services.UsuarioService;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(path="/api/usuarios")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usarioService;
	
	@GetMapping
	public ResponseEntity<Response<List<Usuario>>> listarTodos(){
		return ResponseEntity.ok(new Response<List<Usuario>>(usarioService.listarTodos()));
	}
	
	@GetMapping(path="/{id}")
	public ResponseEntity<Response<Usuario>> listarPorId(@PathVariable(name = "id") String id){
		return ResponseEntity.ok(new Response<Usuario>(this.usarioService.buscarPorId(id)));
	} 
	
	@PostMapping
	public ResponseEntity<Response<Usuario>> cadastrar(@Valid @RequestBody Usuario usuario, BindingResult result){
		if(result.hasErrors()) {
			List<String> erros = new ArrayList<String>();
			result.getAllErrors().forEach(erro -> erros.add(erro.getDefaultMessage()));
			return ResponseEntity.badRequest().body(new Response<Usuario>(erros));
		}
		return ResponseEntity.ok(new Response<Usuario>(this.usarioService.cadastrar(usuario)));
	}
	
	@PutMapping
	public ResponseEntity<Response<Usuario>> atualizar(@PathVariable(name = "id") String id ,@Valid @RequestBody Usuario usuario, BindingResult result){
		if(result.hasErrors()) {
			List<String> erros = new ArrayList<String>();
			result.getAllErrors().forEach(erro -> erros.add(erro.getDefaultMessage()));
			return ResponseEntity.badRequest().body(new Response<Usuario>(erros));
		}
		usuario.setId(id);
		return ResponseEntity.ok(new Response<Usuario>(this.usarioService.atualizar(usuario)));
	}
	
	@DeleteMapping(path="/{id}")
	public ResponseEntity<Response<String>> remover(@PathVariable(name = "id") String id){
		this.usarioService.remover(id);
		return ResponseEntity.ok(new Response<String>("Usuário Removido com sucesso !"));
	}
	
	@PostMapping(path="/validar")
	public ResponseEntity<Response<Usuario>> validar(@Valid @RequestBody Usuario usuario, BindingResult result){
		if(result.hasErrors()) {
			List<String> erros = new ArrayList<String>();
			result.getAllErrors().forEach(erro -> erros.add(erro.getDefaultMessage()));
			return ResponseEntity.badRequest().body(new Response<Usuario>(erros));
		}
		return ResponseEntity.ok(new Response<Usuario>(this.usarioService.validarUsuarioLogado(usuario.getNome(), usuario.getSenha())));
	}
}
