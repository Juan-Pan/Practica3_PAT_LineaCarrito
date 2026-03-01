package com.carrito.practica3.repositorios;

import com.carrito.practica3.entidades.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface RepoUsuario extends CrudRepository<Usuario, Long> {
    Usuario findUsuarioByCorreoUsuario(String correoUsuario);
}
