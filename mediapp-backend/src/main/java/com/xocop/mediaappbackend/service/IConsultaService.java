package com.xocop.mediaappbackend.service;

import com.xocop.mediaappbackend.dto.ConsultaExamenDTO;
import com.xocop.mediaappbackend.dto.ConsultaResumenDTO;
import com.xocop.mediaappbackend.dto.FiltroConsultaDTO;
import com.xocop.mediaappbackend.model.Consulta;
import com.xocop.mediaappbackend.model.ConsultaExamen;

import java.util.List;


public interface IConsultaService extends  ICRUD<Consulta,Integer>{
    Consulta registrarDTO(ConsultaExamenDTO dto);
    List<Consulta> buscarDni(FiltroConsultaDTO filtro);
    List<Consulta> buscarNombres(FiltroConsultaDTO filtro);
    List<Consulta> buscarFecha(FiltroConsultaDTO filtro);
    List<ConsultaExamen> listarExamenesPorConsulta(Integer idConsulta);
    List<ConsultaResumenDTO> listarResumen();
    byte[] generarReporte();

}
