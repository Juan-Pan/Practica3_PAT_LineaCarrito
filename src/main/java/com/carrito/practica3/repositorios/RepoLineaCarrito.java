package com.carrito.practica3.repositorios;

import com.carrito.practica3.entidades.Carrito;
import com.carrito.practica3.entidades.LineaCarrito;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RepoLineaCarrito extends CrudRepository<LineaCarrito, Long> {
    List<LineaCarrito> findByCarrito(Carrito carrito);

}
