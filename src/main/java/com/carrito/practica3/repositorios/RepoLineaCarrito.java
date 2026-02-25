package com.carrito.practica3.repositorios;

import com.carrito.practica3.entidades.LineaCarrito;
import org.springframework.data.repository.CrudRepository;

public interface RepoLineaCarrito extends CrudRepository<LineaCarrito, Long> {
    LineaCarrito findById(long id);
}
