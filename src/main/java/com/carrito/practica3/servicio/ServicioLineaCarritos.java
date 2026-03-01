package com.carrito.practica3.servicio;

import com.carrito.practica3.entidades.Carrito;
import com.carrito.practica3.entidades.LineaCarrito;
import com.carrito.practica3.repositorios.RepoCarrito;
import com.carrito.practica3.repositorios.RepoLineaCarrito;
import com.carrito.practica3.repositorios.RepoUsuario;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.sound.sampled.Line;

@Service
public class ServicioLineaCarritos {
    @Autowired
    RepoCarrito carritoRepo;

    @Autowired
    RepoLineaCarrito carritoRepoLinea;

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Transactional
    public LineaCarrito crearLineaCarrito(LineaCarrito lineaCarrito, Long idCarrito){

        Carrito encontrarCarrito = carritoRepo.findById(idCarrito).orElse(null);

        if(encontrarCarrito == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Carrito no encontrado");
        }

        LineaCarrito lineaCarritoNuevo = new LineaCarrito();

        lineaCarritoNuevo.carrito = encontrarCarrito;
        lineaCarritoNuevo.idArticulo =  lineaCarrito.idArticulo;
        lineaCarritoNuevo.numeroUnidades = lineaCarrito.numeroUnidades;
        lineaCarritoNuevo.precioUnitario = lineaCarrito.precioUnitario;

        //se calcula el coste real de precio unitario * numero de unidades

        lineaCarritoNuevo.costeLinea = lineaCarrito.numeroUnidades *  lineaCarrito.precioUnitario ;

        // se suma el coste final al carrito
        encontrarCarrito.precioFinal = encontrarCarrito.precioFinal +  lineaCarrito.costeLinea;

        // Actualizamos el carrito guardandolo
        carritoRepo.save(encontrarCarrito);

        // Se guarda la linea del carrito
        return carritoRepoLinea.save(lineaCarritoNuevo);

    }
}
