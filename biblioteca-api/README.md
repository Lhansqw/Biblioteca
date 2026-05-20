# Biblioteca API REST

API REST para el Sistema de Biblioteca construida con **Java 17**, **Spring Boot 3.3.0**, **MongoDB** y **Lombok**.

---

## 📂 Estructura del Proyecto

La estructura completa generada es la siguiente:

```text
biblioteca-api/
├── pom.xml                                
├── README.md                               
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── biblioteca/
│   │   │           ├── BibliotecaApiApplication.java  
│   │   │           ├── controller/                   
│   │   │           │   └── LibroController.java      
│   │   │           ├── dto/                           
│   │   │           │   ├── LibroRequest.java          
│   │   │           │   └── LibroResponse.java         
│   │   │           ├── model/                        
│   │   │           │   └── Libro.java                 
│   │   │           ├── repository/                    
│   │   │           │   └── LibroRepository.java       
│   │   │           └── service/                      
│   │   │               └── LibroService.java          
│   │   └── resources
│   │       ├── application.properties                 
│   │       ├── static/                              
│   │       └── templates/                           
│   └── test/                                         
│       └── java/
│           └── com/
│               └── biblioteca/
│                   └── BibliotecaApiApplicationTests.java 
```

---

## 🛠️ Tecnologías y Características

- **Spring Boot 3.3.0**
- **Spring Data MongoDB**
- **Lombok** (para la generación automática de getters, setters, constructores, y métodos `toString` / `equals`)
- **Java 17**

---

## ⚙️ Configuración y Conexión

Edita el archivo `src/main/resources/application.properties` con tu URI de conexión real de MongoDB Atlas:

```properties
spring.data.mongodb.uri=mongodb+srv://adminBiblioteca:<TuPassword>@biblioteca-cluster.ab1cd.mongodb.net/biblioteca_db?retryWrites=true&w=majority
spring.data.mongodb.database=biblioteca_db
server.port=8080
```

---

## 🚀 Endpoints de la API

La API corre por defecto en `http://localhost:8080/api/libros`.

### 1. Listar todos los libros
- **Método:** `GET`
- **Ruta:** `/api/libros`
- **Respuesta Exitosa (200 OK):**
  ```json
  []
  ```

### 2. Registrar un libro
- **Método:** `POST`
- **Ruta:** `/api/libros`
- **Cuerpo (JSON):**
  ```json
  {
    "isbn": "9780307474728",
    "titulo": "Cien años de soledad",
    "autor": "Gabriel García Márquez",
    "anioPublicacion": 1967,
    "categoria": "Realismo Mágico"
  }
  ```
- **Respuesta Exitosa (201 Created):**
  ```json
  {
    "id": "60d5ec4b868e4223d8c1c4e5",
    "isbn": "9780307474728",
    "titulo": "Cien años de soledad",
    "autor": "Gabriel García Márquez",
    "anioPublicacion": 1967,
    "categoria": "Realismo Mágico"
  }
  ```

### 3. Obtener un libro por ID
- **Método:** `GET`
- **Ruta:** `/api/libros/{id}`

### 4. Actualizar un libro
- **Método:** `PUT`
- **Ruta:** `/api/libros/{id}`
- **Cuerpo (JSON):**
  ```json
  {
    "isbn": "9780307474728",
    "titulo": "Cien años de soledad (Edición Especial)",
    "autor": "Gabriel García Márquez",
    "anioPublicacion": 1967,
    "categoria": "Novela"
  }
  ```

### 5. Eliminar un libro
- **Método:** `DELETE`
- **Ruta:** `/api/libros/{id}`
- **Respuesta Exitosa (204 No Content)**
