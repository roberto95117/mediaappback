package com.xocop.mediaappbackend.model;

import javax.persistence.*;

@Entity
@Table(name = "arcchivo")
public class Archivo {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer idArchivo;

    @Column(name = "filename", length = 50)
    private String filename;

    @Column(name = "filetype",length = 15)
    private String filetype;

    @Column(name = "contenido")
    private byte[] value;

    public Integer getIdArchivo() {
        return idArchivo;
    }

    public void setIdArchivo(Integer idArchivo) {
        this.idArchivo = idArchivo;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getFiletype() {
        return filetype;
    }

    public void setFiletype(String filetype) {
        this.filetype = filetype;
    }

    public byte[] getValue() {
        return value;
    }

    public void setValue(byte[] value) {
        this.value = value;
    }
}
