package com.carrito.practica3.servicio;

import com.carrito.practica3.entidades.Carrito;
import com.carrito.practica3.entidades.Usuario;
import com.carrito.practica3.repositorios.RepoCarrito;
import com.carrito.practica3.repositorios.RepoLineaCarrito;
import com.carrito.practica3.repositorios.RepoUsuario;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ServicioCarritos {
    @Autowired
    RepoCarrito repoCarrito;

    @Autowired
    RepoLineaCarrito repoLineaCarrito;

    @Autowired
    RepoUsuario repoUsuario;

    private Logger logger = LoggerFactory.getLogger(getClass());

    public Usuario autentica(String credenciales)
    {
        logger.info("ServicioCarrito: intentando autentificar con: " + credenciales);
        Usuario usuario = repoUsuario.findByCredenciales(credenciales);
        if(usuario == null)
        {
            logger.warn("ServicioCarrito: Usuario no encontrado");
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return usuario;

    }


}
