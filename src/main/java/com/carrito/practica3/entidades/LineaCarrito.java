package com.carrito.practica3.entidades;

import jakarta.persistence.*;

@Entity
public class LineaCarrito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_carrito", nullable = false)
    public Carrito carrito;

    @Column(nullable = false)
    public Double precioUnitario;
    @Column(nullable = false)
    public Integer numeroUnidades;
    @Column(nullable = false)
    public Double CosteLinea;


}
