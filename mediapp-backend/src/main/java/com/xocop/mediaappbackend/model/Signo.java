package com.xocop.mediaappbackend.model;

import javax.annotation.Generated;
import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table( name = "signo")
public class Signo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idSigno;

    @Column(name = "fecha", nullable = false)
    private LocalDateTime fecha;

    @Column(name = "temperatura",nullable = false)
    private Double temperatura;

    @Column(name = "pulso",nullable = false)
    private Double pulso;

    @Column(name = "ritmo_espiratorio",nullable = false)
    private Double ritmoRespiratorio;

    @ManyToOne
    @JoinColumn(name = "id_paciente",nullable = false,foreignKey = @ForeignKey(name = "FK_signo_paciente"))
    private Paciente paciente;

    public Integer getIdSigno() {
        return idSigno;
    }

    public void setIdSigno(Integer idSigno) {
        this.idSigno = idSigno;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public Double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(Double temperatura) {
        this.temperatura = temperatura;
    }

    public Double getPulso() {
        return pulso;
    }

    public void setPulso(Double pulso) {
        this.pulso = pulso;
    }

    public Double getRitmoRespiratorio() {
        return ritmoRespiratorio;
    }

    public void setRitmoRespiratorio(Double ritmoRespiratorio) {
        this.ritmoRespiratorio = ritmoRespiratorio;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

}
