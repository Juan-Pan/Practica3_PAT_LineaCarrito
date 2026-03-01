package com.carrito.practica3.repositorios;

import com.carrito.practica3.entidades.Carrito;
import com.carrito.practica3.entidades.LineaCarrito;
import com.carrito.practica3.entidades.Usuario;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RepoCarrito extends CrudRepository<Carrito, Long> {
    List<Carrito> findByUsuario(Usuario usuario);
}
