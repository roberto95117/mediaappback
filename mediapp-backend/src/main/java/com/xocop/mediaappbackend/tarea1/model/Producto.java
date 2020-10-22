package com.xocop.mediaappbackend.tarea1.model;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "producto")

public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProducto;

    @Size(max = 100,message = "Maximo permitido 100")
    @Size(min= 1, message = "debe contener al menos 1 caracter")
    @Column(name = "nombre", nullable = false,length = 100)
    private String nombre;

    @Size(max = 50, message = "Maximo permitido 50")
    @Size(min = 1,message = "debe contener al menos 1 caracter")
    @Column(name = "marca", nullable = false,length = 50)

    private String marca;

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
}
