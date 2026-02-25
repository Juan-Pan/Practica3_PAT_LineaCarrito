package com.carrito.practica3.entidades;

import jakarta.persistence.*;

@Entity
public class Carrito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    // Iria aca los campos de idUsuario y de Correo prefiero hacerlos en una entidad aparte
    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    public Usuario usuario;

    @Column(nullable = false)
    public String descripcion;
    @Column(nullable = false)
    public Integer numeroUnidades;
    @Column(nullable = false)
    public Double precioFinal;
}
