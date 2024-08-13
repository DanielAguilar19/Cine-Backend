# Cine Backend

Este es el backend del proyecto de gestión de cines, desarrollado en Java utilizando Spring Boot.

## Requisitos

Para ejecutar este proyecto, necesitas tener lo siguiente:

- **Java 17** o superior.
- **Maven** para gestionar las dependencias.
- **MySQL** como base de datos.
- **Puerto 8080** libre en tu máquina.

## Configuración de la Base de Datos

1. Crea una base de datos MySQL llamada `cine`:

   ```sql
   CREATE DATABASE cine;
   ```

2. Asegúrate de que las credenciales de tu base de datos están configuradas correctamente en el archivo `application.properties`:

   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/cine
   spring.datasource.username=tu_usuario
   spring.datasource.password=tu_contraseña
   spring.jpa.hibernate.ddl-auto=update
   ```

## Ejecución del Proyecto

1. Clona el repositorio:

   ```bash
   git clone https://github.com/tu_usuario/tu_repositorio.git
   cd tu_repositorio
   ```

2. Compila y ejecuta el proyecto utilizando Maven:

   ```bash
   mvn spring-boot:run
   ```

3. Una vez que el proyecto esté corriendo, puedes acceder a la documentación de las APIs en Swagger a través del siguiente enlace:

   [Swagger UI - Documentación de APIs](http://localhost:8080/doc/swagger-ui/index.html)

## Endpoints Principales

Aquí encontrarás los endpoints principales para gestionar cines, películas, funciones y más.

- **GET** `/api/peliculas` - Obtiene una lista de todas las películas.
- **POST** `/api/peliculas` - Crea una nueva película.
- **PUT** `/api/peliculas/{id}` - Actualiza una película existente.
- **DELETE** `/api/peliculas/{id}` - Elimina una película.

Y muchos más, consulta la documentación en Swagger para más detalles.
