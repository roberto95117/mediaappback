package com.xocop.mediaappbackend.model;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "medico")
public class Medico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMedico;
    @Column(name = "nombres", nullable = false, length = 75)
    private String nombres;
    @Column(name = "apellidos",nullable = false, length = 75)
    private String apellidos;
    @Size(max = 12,message = "Campo no puede tener mas de 12 caracteres")
    @Column(name = "CMP", nullable = false, length = 12)
    private String CMP;
    @Column(name = "foto_url",nullable = true)
    private String fotoUrl;

    public Integer getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(Integer idMedico) {
        this.idMedico = idMedico;
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

    public String getCMP() {
        return CMP;
    }

    public void setCMP(String CMP) {
        this.CMP = CMP;
    }

    public String getFotoUrl() {
        return fotoUrl;
    }

    public void setFotoUrl(String fotoUrl) {
        this.fotoUrl = fotoUrl;
    }
}
