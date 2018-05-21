package com.lucas.crud.api.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.lucas.crud.api.documents.Usuario;

public interface UsuarioRepository extends MongoRepository<Usuario, String> {
	
	@Query("{'nome' : ?0, 'senha' : ?1}")
	Usuario validaUsuario(String nome, String senha);

}
