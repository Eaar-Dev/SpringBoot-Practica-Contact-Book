@ -1 +1,122 @@

# SpringBoot-Practica-Contact-Book

# 📚 API REST – Agenda de Contaactos con Spring Boot

![Java](https://img.shields.io/badge/Java-17-blue?logo=java)
![Spring Boot](https://img.shields.io/badge/SpringBoot-3-green?logo=spring)
![Build](https://img.shields.io/badge/Build-Maven-orange?logo=apache-maven)
![Tests](https://img.shields.io/badge/Tests-JUnit5-yellow?logo=testing-library)
![License](https://img.shields.io/badge/License-MIT-lightgrey)

Este proyecto es una **API REST** construida con **Spring Boot**, que permite gestionar un catálogo de contactos.
Incluye operaciones CRUD, validación de datos, pruebas unitarias con JUnit + MockMvc y documentación con Swagger.

---

## 🚀 Tecnologías utilizadas

- ☕ **Java 17+**
- 🍃 **Spring Boot 3+**
- 🌐 **Spring Web**
- 💾 **Spring Data JPA + H2 Database (en memoria)**
- 🔧 **Lombok**
- 🧪 **JUnit 5 + MockMvc**
- 📖 **Swagger OpenAPI**

---

## ⚙️ Instalación y ejecución

1. Clonar el repositorio:

   ```bash
   git clone https://github.com/Eaar-Dev/SpringBoot-Practica-Contact-Book.git
   cd SpringBoot-Practica-Contact-Book
   ```

2. Compilar y ejecutar con Maven:

   ```bash
   ./mvnw spring-boot:run
   ```

3. La API estará disponible en:

   ```
   http://localhost:8080/api/contact-book
   ```

4. Documentación Swagger UI:

   ```
   http://localhost:8080/swagger-ui.html
   ```

---

## 📌 Endpoints principales

| Método   | Endpoint                 | Descripción             |
| -------- | ------------------------ | ----------------------- |
| `POST`   | `/api/contact-book`      | Crear un contacto       |
| `GET`    | `/api/contact-book`      | Listar todos contactos  |
| `GET`    | `/api/contact-book/{id}` | Obtener contacto por ID |
| `PUT`    | `/api/contact-book/{id}` | Actualizar contacto     |
| `DELETE` | `/api/contact-book/{id}` | Eliminar contacto       |

---

## 📖 Ejemplo de uso

**Crear un Contacto**

```http
POST /api/contact-book
Content-Type: application/json
```

**Body**

```json
{
  "name": "Alejandro AR",
  "email": "ejemplode@correo.com",
  "phoneNumber": "(número telefónico)",
  "address": "Dirección a probar"
}
```

**Response (201 Created)**

```json
{
  "id": 1,
  "name": "Alejandro AR",
  "email": "ejemplode@correo.com",
  "phoneNumber": "(número telefónico)",
  "address": "Dirección a probar"
}
```

---

## 🧪 Pruebas

Ejecutar pruebas unitarias:

```bash
./mvnw test
```

Ejemplo de test:

```java
mockMvc.perform(post("/api/contact-book")
        .contentType(MediaType.APPLICATION_JSON)
        .content("{\"name\":\"Alejandro AR\",
        \"email\":\"ejemplode@correo.com\",
        \"phoneNumber\":\"5512345678\",
        \"address\":\"Dirección requerida\"}"))
        .andExpect(status().isCreated())
        .andExpect(jsonPath("$.name").value("Alejandro AR"));
```

---

## 📜 Licencia

Este proyecto se distribuye bajo la licencia MIT.
Puedes usarlo y modificarlo libremente.
