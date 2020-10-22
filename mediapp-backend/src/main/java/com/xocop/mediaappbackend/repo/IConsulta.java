package com.xocop.mediaappbackend.repo;

import com.xocop.mediaappbackend.model.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface IConsulta extends JpaRepository<Consulta, Integer> {

    @Query(value="from Consulta c where c.paciente.dni=:dni")
    List<Consulta> buscarDni(@Param("dni")String dni);

    @Query(value="from Consulta c where LOWER(c.paciente.nombres) like %:nombreCompleto% or LOWER (c.paciente.apellidos) like %:nombreCompleto%")
    List<Consulta> buscarNombres(@Param("nombreCompleto")String nombreCompleto);

    @Query(value = "from Consulta  c where c.fecha between:fechaConsulta and :fechasgte")
    List<Consulta> buscarFecha(@Param("fechaConsulta") LocalDateTime fechaConsulta, @Param("fechasgte")LocalDateTime fechasgte);

    @Query(value = "select * from fn_listarResumen()", nativeQuery = true)
    List<Object[]> listarResumen();
}
