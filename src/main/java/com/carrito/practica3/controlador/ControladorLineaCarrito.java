package com.carrito.practica3.controlador;

import com.carrito.practica3.entidades.LineaCarrito;
import com.carrito.practica3.servicio.ServicioCarritos;
import com.carrito.practica3.servicio.ServicioLineaCarritos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.sound.sampled.Line;

@RestController
@RequestMapping("/api/linea")
public class ControladorLineaCarrito {
    @Autowired
    private ServicioLineaCarritos servicioLineaCarritos;

    //ENDPOINT POST
    @PostMapping("/{idCarrito}")
    @ResponseStatus(HttpStatus.CREATED)
    public LineaCarrito crear(@RequestBody LineaCarrito lineaCarritoNuevo, @PathVariable Long idCarrito) {

        return servicioLineaCarritos.crearLineaCarrito(lineaCarritoNuevo, idCarrito);
    }

    //ENDPOINT GET
    @GetMapping("/{idCarrito}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public LineaCarrito buscar(@PathVariable Long idCarrito)
    {
        return servicioLineaCarritos.buscarLineaCarrito(idCarrito);
    }

}
