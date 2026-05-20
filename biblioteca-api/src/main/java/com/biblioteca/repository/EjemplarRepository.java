package com.biblioteca.repository;

import com.biblioteca.model.Ejemplar;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface EjemplarRepository extends MongoRepository<Ejemplar, String> {
    List<Ejemplar> findByLibroId(String libroId);
}
