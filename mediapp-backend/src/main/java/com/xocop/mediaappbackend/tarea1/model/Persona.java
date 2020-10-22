package com.xocop.mediaappbackend.tarea1.model;


import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "persona")
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPersona;


    @Column(name = "nombres", nullable = false,length = 50)
    @Size(min = 1,message = "El campo debe contener al menos 1 caracter")
    @Size(max = 50,message = "El campo nombres es de 50 caracteres")
    private String nombres;


    @Column(name = "apellidos", nullable = false,length = 50)
    @Size(min = 1, message = "El campo apellidos es de 50 caracteres")
    @Size(max = 50, message = "EL campo debe contener al menos 1 caracter")
    private String apellidos;

    public Integer getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Integer idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
}
