package com.xocop.mediaappbackend.model;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "especialidad")
public class Especialidad  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEspecialidad;
    @Size(max = 75, message = "Nombre es mayor al limite de valor permitido")
    @Column(name = "nombre", nullable = false, length = 75)
    private String nombre;

    public Integer getIdEspecialidad() {
        return idEspecialidad;
    }

    public void setIdEspecialidad(Integer idEspecialidad) {
        this.idEspecialidad = idEspecialidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
