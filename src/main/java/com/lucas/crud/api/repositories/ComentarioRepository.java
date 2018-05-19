package com.lucas.crud.api.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.lucas.crud.api.documents.Comentario;

public interface ComentarioRepository extends MongoRepository<Comentario, String> {

}
