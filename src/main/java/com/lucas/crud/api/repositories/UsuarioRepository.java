package com.lucas.crud.api.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.lucas.crud.api.documents.Usuario;

public interface UsuarioRepository extends MongoRepository<Usuario, String> {

}
