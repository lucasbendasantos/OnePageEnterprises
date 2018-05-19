package com.lucas.crud.api.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucas.crud.api.documents.Comentario;
import com.lucas.crud.api.repositories.ComentarioRepository;
import com.lucas.crud.api.services.ComentarioService;


@Service
public class ComentarioServiceImpl implements ComentarioService {
	@Autowired
	private ComentarioRepository comentarioRepository;
	
	public List<Comentario> listarTodos() {
		return this.comentarioRepository.findAll();
	}

	public Comentario buscarPorId(String id) {
		return this.comentarioRepository.findOne(id);
	}

	public Comentario cadastrar(Comentario comentario) {
		return this.comentarioRepository.save(comentario);
	}

	public Comentario atualizar(Comentario comentario) {
		return this.comentarioRepository.save(comentario);
	}

	public void remover(String id) {
		this.comentarioRepository.delete(id);
	}

}
