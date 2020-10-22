package com.xocop.mediaappbackend.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "menu")
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMenu;

    @Column(name = "icono",nullable = false, length = 75)
    private String icono;

    @Column(name = "nombre", nullable = false,length = 75)
    private String nombre;

    @Column(name = "url",nullable = false, length = 75)
    private String url;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "menuRol", joinColumns = @JoinColumn(name = "idMenu",referencedColumnName = "idMenu"),inverseJoinColumns = @JoinColumn(name = "idRol", referencedColumnName = "idRol"))
    private List<Rol> roles;


    public Integer getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(Integer idMenu) {
        this.idMenu = idMenu;
    }

    public String getIcono() {
        return icono;
    }

    public void setIcono(String icono) {
        this.icono = icono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
