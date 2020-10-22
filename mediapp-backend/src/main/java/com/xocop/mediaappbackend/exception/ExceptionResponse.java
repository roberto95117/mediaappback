package com.xocop.mediaappbackend.exception;

import java.time.LocalDateTime;

public class ExceptionResponse {
    private LocalDateTime fechaHora;
    private String mensaje;
    private String detalles;

    public ExceptionResponse(LocalDateTime fechaHora, String mensaje, String detalles) {
        this.fechaHora = fechaHora;
        this.mensaje = mensaje;
        this.detalles = detalles;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getDetalles() {
        return detalles;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }
}
