package com.xocop.mediaappbackend.model;

//import io.swagger.annotations.ApiModel;
//import io.swagger.annotations.ApiModelProperty;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

//para documentar el API con swagger antiguo
//@ApiModel(description = "Informacion del paciente")
@Schema(description = "Informacion del Paciente")
@Entity
//se pone para que se cree la tabla en db con el nombre que le indiquemos aca, es opcional
@Table(name = "paciente")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPaciente;

    //@ApiModelProperty(notes = "Nombres debe tener un minimo de 3 caracteres")
    //sino se pone @column creara los string con longitud 255 por defecto
    @Schema(description = "Nombres debe tener un minimo de 3 caracteres")
    @Size(min = 3,message = "Nombres debe tener un minimo de 3 caracteres")
    @Column(name = "nombres",nullable = false,length = 70)
    private String nombres;

    @Column(name = "apellidos",nullable = false,length = 70)
    private String apellidos;
    @Column(name = "dni",nullable = false,length = 13)
    private String dni;
    @Column(name = "direccion",nullable = true,length = 150)
    private String direccion;
    @Column(name = "telefono",nullable = true,length = 8)
    private String telefono;
    @Email
    @Column(name = "email",nullable = true,length = 50)
    private String email;

    public Integer getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Integer idPaciente) {
        this.idPaciente = idPaciente;
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

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
