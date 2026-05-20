package com.biblioteca.service;

import com.biblioteca.dto.PrestamoRequest;
import com.biblioteca.dto.PrestamoResponse;

import java.util.List;

public interface PrestamoService {
    PrestamoResponse crearPrestamo(PrestamoRequest request);
    List<PrestamoResponse> listarPrestamos();
    List<PrestamoResponse> listarPrestamosPorUsuario(String usuarioId);
    PrestamoResponse consultarPrestamo(String id);
    PrestamoResponse actualizarPrestamo(String id, PrestamoRequest request);
    void eliminarPrestamo(String id);
}
