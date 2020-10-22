package com.xocop.mediaappbackend.service;

import com.xocop.mediaappbackend.model.Paciente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IPacienteService extends  ICRUD<Paciente,Integer>{
    Page<Paciente> listarPaginado(Pageable pageable);
}
