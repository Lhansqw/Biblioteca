package com.biblioteca.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "usuarios")
public class Usuario {
    @Id
    private String id;
    private String nombre;
    private String correo;
    
    // Tipo de usuario: ESTUDIANTE, PROFESOR, BIBLIOTECARIO
    private String tipo;
    
    // Campos específicos que pueden ser nulos dependiendo del tipo
    private String codigo;      // Para estudiantes y profesores
    private String programa;    // Para estudiantes
    private String facultad;    // Para profesores
    private String turno;       // Para bibliotecarios
}
