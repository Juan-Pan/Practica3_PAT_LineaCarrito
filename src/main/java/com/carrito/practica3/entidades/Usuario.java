package com.carrito.practica3.entidades;

import jakarta.persistence.*;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column
    public String correo_usuario;

    @Column
    public String credendenciales;


}
