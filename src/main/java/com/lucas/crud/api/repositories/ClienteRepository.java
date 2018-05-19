package com.lucas.crud.api.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.lucas.crud.api.documents.Cliente;

public interface ClienteRepository extends MongoRepository<Cliente, String> {

}
