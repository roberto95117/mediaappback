package com.xocop.mediaappbackend.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "consultaExamen")

//se linkea a la clase con la llave compuesta
@IdClass(ConsultaExamenPK.class)
public class ConsultaExamen  {

    @Id
    private  Examen examen;

    @Id
    private Consulta consulta;

    public Examen getExamen() {
        return examen;
    }

    public void setExamen(Examen examen) {
        this.examen = examen;
    }

    public Consulta getConsulta() {
        return consulta;
    }

    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }
}
