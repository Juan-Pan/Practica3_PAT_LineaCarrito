package com.carrito.practica3.repositorios;

import com.carrito.practica3.entidades.Carrito;
import org.springframework.data.repository.CrudRepository;

public interface RepoCarrito extends CrudRepository<Carrito, Long> {
    Carrito findByCarritoId(Long carritoId);
}
