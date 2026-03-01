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
import org.springframework.transaction.annotation.Transactional;
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

    @Transactional
    public Carrito crearCarrito(Carrito carrito, Long idUsuario)
    {
        logger.info("Intentando crear un carrito para el usuario " + idUsuario);

        Usuario usuarioEncontrado = repoUsuario.findById(idUsuario).orElse(null);

        if(usuarioEncontrado == null)
        {
            logger.error("No existe el usuario con el id: " + idUsuario);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "El usuario no existe");
        }
        //ahora se contruye el carrito

        Carrito carritoNuevo = new Carrito();

        carritoNuevo.usuario =  usuarioEncontrado;
        carritoNuevo.descripcion = carrito.descripcion;
        carritoNuevo.precioFinal = 0.0;

        Carrito carritoGuardado = repoCarrito.save(carritoNuevo);
        logger.info("Carrito guardado: " + carritoGuardado);
        return carritoGuardado;
    }

    public Carrito buscarCarrito(Long idCarrito)
    {
        Carrito carrito = repoCarrito.findById(idCarrito).orElse(null);
        if (carrito == null)
        {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Carrito no encontrado");
        }
        return carrito;
    }
}

