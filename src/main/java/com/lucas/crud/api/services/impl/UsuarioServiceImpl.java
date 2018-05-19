package com.lucas.crud.api.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucas.crud.api.documents.Usuario;
import com.lucas.crud.api.repositories.UsuarioRepository;
import com.lucas.crud.api.services.UsuarioService;



@Service
public class UsuarioServiceImpl implements UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public List<Usuario> listarTodos() {
		return this.usuarioRepository.findAll();
	}

	public Usuario buscarPorId(String id) {
		return this.usuarioRepository.findOne(id);
	}

	public Usuario cadastrar(Usuario usuario) {
		return this.usuarioRepository.save(usuario);
	}

	public Usuario atualizar(Usuario usuario) {
		return this.usuarioRepository.save(usuario);
	}

	public void remover(String id) {
		this.usuarioRepository.delete(id);
	}

}
