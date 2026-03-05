# Practica 3 de PAT (Extender funcionalidad incorporando persistencia y la capa de servicios)

## Descripción 

Esta práctica extiende la version anterior, aplicando persistencia y usando una capa de servicios. 

## Campos del Carrito de la entidad Carrito
- id(Long): identificador único. PK
- usuario (Usuario): relacion muchos a uno (ManyToOne) de la entidad usuario.
- descripcion (String): descripción del carrito de compras.
- precioFinal(Double): precio final del carrito de compras.
## Campos de la línea carrito de la entidad LineaCarrito
- id(Long): identificador único. PK
- carrito(Carrito): relación muchos a uno (ManyToOne) de la entidad Carrito. (Aclaración: un carrito puede tener muchas líneas de carrito pero las líneas de carrito solo le pertenecen a un carrito).
- idArticulo (Long): id del artículo.
- precioUnitario(Double): precio del artículo.
- numeroUnidades (Integer): numero de unidades a comprar.
- costeLinea (Double): coste total de la linea del carrito.
## Campos del usuario de la entidad Usuario
- id(Long): identificador único. PK
- correoUsuario(String): correo del usuario para identificar a quien le pertenece el carrito.
- credenciales (String): credenciales del usuario con su @JsonIgnore para no mostrarlas cuando se consulte (aunque en este caso no se usó este campo debido a que no usamos autorizaciones).
## Tecnologías usadas
- java 24.0.2
- Spring boot 3.0.5
- maven
- Postman
## Endpoints
### ControladorCarrito
| Método | Endpoint                         | Descripción                                | Posibles respuestas |
|--------|----------------------------------|--------------------------------------------|-------------|
| POST   | /api/carrito/usuario/{idUsuario} | Crea un nuevo carrito de compras(vacio).   | 201: Created| 
| GET    | /api/carrito/{idCarrito}         | Obtiene un carrito de compras por su ID.   | 200: OK. 404: Not Found: Carrito no encontrado|
| PUT    | /api/carrito/{idCarrito}         | Actualiza un carrito de compras existente. | 200: OK. 400: Bad Request: Json invalido. 404: Not Found: Carrito no encontrado|
|DELETE  | /api/carrito/{idCarrito}         | Elimina un carrito de compras por su ID.   | 204: No Content. 404: Not Found: Carrito no encontrado|
### ControladorLineaCarrito
| Método | Endpoint               | Descripción                               | Posibles respuestas |
|--------|------------------------|-------------------------------------------|-------------|
| POST   | /api/linea/{idCarrito} | Crea una linea de carrito.                | 201: Created| 
| GET    | /api/linea/{idLinea}   | Obtiene una linea carrito por su ID.      | 200: OK. 404: Not Found: Carrito no encontrado|
| PUT    | /api/linea/{idLinea}   | Actualiza una linea de compras existente. | 200: OK. 400: Bad Request: Json invalido. 404: Not Found: Carrito no encontrado|
|DELETE  | /api/linea/{idLinea}   | Elimina una linea de compras por su ID.   | 204: No Content. 404: Not Found: Carrito no encontrado|
