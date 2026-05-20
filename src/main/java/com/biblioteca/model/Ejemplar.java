package com.biblioteca.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "ejemplares")
public class Ejemplar {
    @Id
    private String id;
    
    // Referencia al ID del Libro
    private String libroId;
    
    private String codigoEjemplar;
    
    // DISPONIBLE, PRESTADO, EN_MANTENIMIENTO
    private String estado; 
    
    private String ubicacion;
}
