package com.carrito.practica3.entidades;

import jakarta.persistence.*;

@Entity
public class LineaCarrito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @ManyToOne
    @JoinColumn(name = "id_carrito", nullable = false)
    public Carrito carrito;

    @Column(nullable = false, unique = true)
    public Long idArticulo;

    @Column(nullable = false)
    public Double precioUnitario;

    @Column(nullable = false)
    public Integer numeroUnidades;

    @Column(nullable = false)
    public Double costeLinea;

    public void setCarrito(Carrito carrito){
        this.carrito = carrito;
    }
    public void setIdArticulo(Long idArticulo)
    {
        this.idArticulo = idArticulo;
    }
    public void setPrecioUnitario(Double precioUnitario)
    {
        this.precioUnitario = precioUnitario;
    }
    public void setNumeroUnidades(Integer numeroUnidades)
    {
        this.numeroUnidades = numeroUnidades;
    }
    public void setCosteLinea(Double costeLinea)
    {
        this.costeLinea = costeLinea;
    }


}
