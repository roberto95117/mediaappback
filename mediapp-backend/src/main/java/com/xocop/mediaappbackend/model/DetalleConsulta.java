package com.xocop.mediaappbackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "detalleConsulta")
public class DetalleConsulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDetalleConsulta;


    @JsonIgnore //para que no de clavos en el envio del JSON al momento de ingresar el idConsulta en el detalle, ya que al momento de crearlo ese idConsulta no existe
    @ManyToOne
    @JoinColumn(name = "id_consulta", nullable = false, foreignKey = @ForeignKey(name = "FK_consulta_detalle"))
    private Consulta consulta;


    @Column(name = "diagnostico", nullable = false, length = 75)
    private String diagnostico;

    @Column(name = "tratamiento", nullable = false,length = 75)
    private String tratamiento;

    public Integer getIdDetalleConsulta() {
        return idDetalleConsulta;
    }

    public void setIdDetalleConsulta(Integer idDetalleConsulta) {
        this.idDetalleConsulta = idDetalleConsulta;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(String tratamiento) {
        this.tratamiento = tratamiento;
    }
    public Consulta getConsulta() {
        return consulta;
    }

    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }
}
