package com.xocop.mediaappbackend.tarea1.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table( name = "detalleVenta")
public class DetalleVenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDetalleVenta;

    @JsonIgnore
    @ManyToOne
    @JoinColumn( name = "idVenta", nullable = false, foreignKey = @ForeignKey(name = "FK_DETALLEVENTA_VENTA"))
    private Venta venta;

    @ManyToOne
    @JoinColumn(name = "idProducto", nullable = false,foreignKey = @ForeignKey(name = "FK_DETALLEVENTA_PRODUCTO"))
    private Producto producto;

    @Column(name = "cantidad", nullable = false)
    private Integer cantidad;

    public Integer getIdDetalleVenta() {
        return idDetalleVenta;
    }

    public void setIdDetalleVenta(Integer idDetalleVenta) {
        this.idDetalleVenta = idDetalleVenta;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
}
