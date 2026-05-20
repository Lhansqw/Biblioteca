package com.biblioteca.service;

import com.biblioteca.dto.EjemplarRequest;
import com.biblioteca.dto.EjemplarResponse;

import java.util.List;

public interface EjemplarService {
    EjemplarResponse crearEjemplar(EjemplarRequest request);
    List<EjemplarResponse> listarEjemplares();
    List<EjemplarResponse> listarEjemplaresPorLibro(String libroId);
    EjemplarResponse consultarEjemplar(String id);
    EjemplarResponse actualizarEjemplar(String id, EjemplarRequest request);
    void eliminarEjemplar(String id);
}
