package com.xocop.mediaappbackend.model;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

//para llave compuesta de la tabla, ya que no es un entity
@Embeddable
public class ConsultaExamenPK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "idExamen", nullable = false)
    private  Examen examen;

    @ManyToOne
    @JoinColumn(name = "idConsulta", nullable = false)
    private  Consulta consulta;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConsultaExamenPK that = (ConsultaExamenPK) o;
        return examen.equals(that.examen) &&
                consulta.equals(that.consulta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(examen, consulta);
    }
}
