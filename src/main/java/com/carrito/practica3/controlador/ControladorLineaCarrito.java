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
    @GetMapping("/{idLinea}")
    @ResponseStatus(HttpStatus.OK)
    public LineaCarrito buscar(@PathVariable Long idLinea) {
        return servicioLineaCarritos.buscarLineaCarrito(idLinea);
    }

    //ENDPOINT PUT
    @PutMapping("/{idLinea}")
    @ResponseStatus(HttpStatus.OK)
    public LineaCarrito actualizar(@PathVariable Long idLinea, @RequestBody LineaCarrito lineaCarritoActualizada) {
        return servicioLineaCarritos.actualizarLineaCarrito(idLinea, lineaCarritoActualizada);
    }

    //ENDPOINT DELETE
    @DeleteMapping("/{idLinea}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void borrarLinea(@PathVariable Long idLinea) {
        servicioLineaCarritos.borrarLineaCarrito(idLinea);
    }

}
