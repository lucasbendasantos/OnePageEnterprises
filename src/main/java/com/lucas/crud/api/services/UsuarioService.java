package com.lucas.crud.api.services;

import java.util.List;

import com.lucas.crud.api.documents.Usuario;

public interface UsuarioService {
	
	List<Usuario> listarTodos();
	Usuario buscarPorId(String id);
	Usuario cadastrar(Usuario usuario);
	Usuario atualizar(Usuario usuario);
	void remover(String id);

}
