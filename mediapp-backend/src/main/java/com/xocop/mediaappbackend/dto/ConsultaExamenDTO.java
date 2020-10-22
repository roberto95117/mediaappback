package com.xocop.mediaappbackend.dto;

import com.xocop.mediaappbackend.model.Consulta;
import com.xocop.mediaappbackend.model.Examen;

import java.util.List;

public class ConsultaExamenDTO {
    private Consulta consulta;
    private List<Examen> listExamen;

    public Consulta getConsulta() {
        return consulta;
    }

    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }

    public List<Examen> getListExamen() {
        return listExamen;
    }

    public void setListExamen(List<Examen> listExamen) {
        this.listExamen = listExamen;
    }
}
