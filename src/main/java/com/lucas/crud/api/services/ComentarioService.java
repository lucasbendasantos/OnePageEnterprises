package com.lucas.crud.api.services;

import java.util.List;

import com.lucas.crud.api.documents.Comentario;


public interface ComentarioService {
	
	List<Comentario> listarTodos();
	Comentario buscarPorId(String id);
	Comentario cadastrar(Comentario comentario);
	Comentario atualizar(Comentario comentario);
	void remover(String id);
	
}
