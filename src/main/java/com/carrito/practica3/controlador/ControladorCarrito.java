package com.carrito.practica3.controlador;

import com.carrito.practica3.entidades.Carrito;
import com.carrito.practica3.servicio.ServicioCarritos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/carrito")
public class ControladorCarrito {
    @Autowired
    private ServicioCarritos servicioCarritos;

    //ENDPOINT POST
    @PostMapping("/usuario/{idUsuario}")
    @ResponseStatus(HttpStatus.CREATED)
    public Carrito crearCarrito(@RequestBody Carrito carritoNuevo, @PathVariable Long idUsuario) {
        return servicioCarritos.crearCarrito(carritoNuevo, idUsuario);
    }

    //ENDPOINT GET
    @GetMapping("/{idCarrito}")
    @ResponseStatus(HttpStatus.OK)
    public Carrito buscarCarrito(@PathVariable Long idCarrito) {
        return servicioCarritos.buscarCarrito(idCarrito);
    }

    //ENDPOINT PUT

    @PutMapping("/{idCarrito}")
    @ResponseStatus(HttpStatus.OK)
    public Carrito actualizarCarrito(@PathVariable Long idCarrito, @RequestBody Carrito carritoActualizado) {
        return servicioCarritos.actualizarCarrito(carritoActualizado, idCarrito);
    }

    //ENDPOINT DELETE
    @DeleteMapping("/{idCarrito}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void borrarCarrito(@PathVariable Long idCarrito) {
        servicioCarritos.borrarCarrito(idCarrito);
    }

}
