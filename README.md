# API Web Hackatón 2024

## Descripción del Proyecto
Este proyecto es una **API** desarrollada para ser utilizada en una aplicación web que maneja **usuarios** y **actividades**. Está construida con el framework de **Spring Boot** en **Java**.

## Requisitos Previos
- **Java 17** o superior.
- Base de datos **MySQL** con una base de datos llamada `apiwebbbdd_pthackaton_abel`. (Esto puede ser modificado en el archivo `application.properties` del proyecto).
- Usuario con permisos **root** y contraseña `M@s7erKey`. (También se puede cambiar en `application.properties`).

## Instalación y Ejecución del Proyecto

1. **Clonar el Repositorio** a tu máquina local:
   ```bash
    git clone https://github.com/llavefija/API_Web_Hackaton.git
   
2. **Navegar al Directorio** del Proyecto: `cd API_Web_Hackaton`
  
  
3. **Iniciar** el Proyecto:

Desde un IDE compatible con Java, localiza y ejecuta la clase `ApiWebHackatonApplication`.
O bien, desde la terminal, ejecuta el siguiente comando:

  ```bash
  mvn spring-boot:run
  ```
Una vez iniciado, la API estará disponible en: http://localhost:8080.

## Endpoints

### Actividades
- **Inicial**: 
  - **Método**: `GET`
  - **URL**: `http://localhost:8080/appActivitats`
  - **Descripción**: Obtiene una lista inicial de actividades.

- **Crear actividad**: 
  - **Método**: `POST`
  - **URL**: `http://localhost:8080/appActivitats/activitat`
  - **Descripción**: Crea una nueva actividad.
  - **Ejemplo de Body**:
    ```json
    {
      "nombre": "Nombre de la actividad",
      "fecha": "2024-10-11",
      "descripcion": "Descripción de la actividad"
    }
    ```

- **Ver actividades**: 
  - **Método**: `GET`
  - **URL**: `http://localhost:8080/appActivitats/activitats`
  - **Descripción**: Obtiene todas las actividades registradas.

- **Añadir un usuario a la actividad**: 
  - **Método**: `POST`
  - **URL**: `http://localhost:8080/appActivitats/activitats/{id}/join`
  - **Descripción**: Añade un usuario a la actividad especificada.
  - **Ejemplo de Body**:
    ```json
    {
      "userId": 1
    }
    ```

- **Importar JSON**: 
  - **Método**: `POST`
  - **URL**: `http://localhost:8080/appActivitats/import`
  - **Descripción**: Importa datos de actividades desde un archivo JSON.
  - **Ejemplo de Body**:
    ```json
    [
      {
        "nombre": "Actividad 1",
        "fecha": "2024-10-12",
        "descripcion": "Descripción de actividad 1"
      },
      {
        "nombre": "Actividad 2",
        "fecha": "2024-10-13",
        "descripcion": "Descripción de actividad 2"
      }
    ]
    ```

- **Exportar JSON**: 
  - **Método**: `GET`
  - **URL**: `http://localhost:8080/appActivitats/export`
  - **Descripción**: Exporta todas las actividades a un archivo JSON.

### Usuarios
- **Crear usuario**: 
  - **Método**: `POST`
  - **URL**: `http://localhost:8080/appActivitats/user`
  - **Descripción**: Crea un nuevo usuario.
  - **Ejemplo de Body**:
    ```json
    {
      "nombre": "Nombre del usuario",
      "email": "usuario@example.com",
      "contrasena": "contraseña123"
    }
    ```

- **Ver usuarios**: 
  - **Método**: `GET`
  - **URL**: `http://localhost:8080/appActivitats/users`
  - **Descripción**: Obtiene todos los usuarios registrados.

- **Ver usuario específico**: 
  - **Método**: `GET`
  - **URL**: `http://localhost:8080/appActivitats/users/{id}`
  - **Descripción**: Obtiene la información de un usuario específico.

- **Modificar usuario específico**: 
  - **Método**: `PUT`
  - **URL**: `http://localhost:8080/appActivitats/users/{id}`
  - **Descripción**: Modifica la información de un usuario específico.
  - **Ejemplo de Body**:
    ```json
    {
      "nombre": "Nuevo Nombre",
      "email": "nuevoemail@example.com"
    }
    ```

- **Eliminar usuario específico**: 
  - **Método**: `DELETE`
  - **URL**: `http://localhost:8080/appActivitats/users/{id}`
  - **Descripción**: Elimina un usuario específico.

## Cumplimiento de Requisitos
**Requisitos funcionales**: El proyecto cumple con todos los requisitos funcionales especificados.  

**Buenas prácticas de programación**: Se han seguido buenas prácticas en la organización y escritura del código.  

**Patrón estructural**: El proyecto sigue un patrón estructural claro.  

**Responsabilidad única**: Las funciones del código tienen una única responsabilidad.  

**Escalabilidad y reutilización**: El código está diseñado para ser escalable y reutilizable.  

**Optimización y rendimiento**: Se ha optimizado el código para un rendimiento eficiente.  

**Documentación**: Este README proporciona una documentación clara y precisa sobre el proyecto y su funcionamiento.  


##### Autor del projecto Abel Cumbreño Pinadero abelcumbrenobalmes@gmail.com
