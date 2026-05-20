package com.biblioteca.service.impl;

import com.biblioteca.dto.EjemplarRequest;
import com.biblioteca.dto.EjemplarResponse;
import com.biblioteca.model.Ejemplar;
import com.biblioteca.repository.EjemplarRepository;
import com.biblioteca.repository.LibroRepository;
import com.biblioteca.service.EjemplarService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EjemplarServiceImpl implements EjemplarService {

    private final EjemplarRepository ejemplarRepository;
    private final LibroRepository libroRepository;

    public EjemplarServiceImpl(EjemplarRepository ejemplarRepository, LibroRepository libroRepository) {
        this.ejemplarRepository = ejemplarRepository;
        this.libroRepository = libroRepository;
    }

    @Override
    public EjemplarResponse crearEjemplar(EjemplarRequest request) {
        // Verificar si el libro existe
        libroRepository.findById(request.getLibroId())
                .orElseThrow(() -> new RuntimeException("Libro no encontrado con ID: " + request.getLibroId()));

        Ejemplar ejemplar = new Ejemplar();
        ejemplar.setLibroId(request.getLibroId());
        ejemplar.setCodigoEjemplar(request.getCodigoEjemplar());
        ejemplar.setEstado(request.getEstado());
        ejemplar.setUbicacion(request.getUbicacion());

        Ejemplar guardado = ejemplarRepository.save(ejemplar);
        return mapToResponse(guardado);
    }

    @Override
    public List<EjemplarResponse> listarEjemplares() {
        return ejemplarRepository.findAll().stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<EjemplarResponse> listarEjemplaresPorLibro(String libroId) {
        return ejemplarRepository.findByLibroId(libroId).stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public EjemplarResponse consultarEjemplar(String id) {
        Ejemplar ejemplar = ejemplarRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ejemplar no encontrado con ID: " + id));
        return mapToResponse(ejemplar);
    }

    @Override
    public EjemplarResponse actualizarEjemplar(String id, EjemplarRequest request) {
        Ejemplar ejemplar = ejemplarRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ejemplar no encontrado con ID: " + id));

        // Verificar si el libro existe
        libroRepository.findById(request.getLibroId())
                .orElseThrow(() -> new RuntimeException("Libro no encontrado con ID: " + request.getLibroId()));

        ejemplar.setLibroId(request.getLibroId());
        ejemplar.setCodigoEjemplar(request.getCodigoEjemplar());
        ejemplar.setEstado(request.getEstado());
        ejemplar.setUbicacion(request.getUbicacion());

        Ejemplar guardado = ejemplarRepository.save(ejemplar);
        return mapToResponse(guardado);
    }

    @Override
    public void eliminarEjemplar(String id) {
        ejemplarRepository.deleteById(id);
    }

    private EjemplarResponse mapToResponse(Ejemplar ejemplar) {
        return new EjemplarResponse(
                ejemplar.getId(),
                ejemplar.getLibroId(),
                ejemplar.getCodigoEjemplar(),
                ejemplar.getEstado(),
                ejemplar.getUbicacion()
        );
    }
}
