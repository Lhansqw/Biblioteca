package com.biblioteca.repository;

import com.biblioteca.model.Prestamo;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PrestamoRepository extends MongoRepository<Prestamo, String> {
    List<Prestamo> findByUsuarioId(String usuarioId);
    List<Prestamo> findByEjemplarId(String ejemplarId);
}
