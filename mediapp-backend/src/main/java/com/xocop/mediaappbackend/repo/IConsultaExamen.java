package com.xocop.mediaappbackend.repo;

import com.xocop.mediaappbackend.model.ConsultaExamen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface IConsultaExamen extends JpaRepository<ConsultaExamen,Integer> {

    @Transactional //se requiere para los procedimientos dml
    @Modifying//cuando es insert,update,delete se pone el modifying ya que son procesos y noc consultas
    @Query(value="INSERT INTO consulta_examen(id_consulta,id_examen) values(:idConsulta,:idExamen)", nativeQuery = true)
    Integer registrar(@Param("idConsulta") Integer idConsulta, @Param("idExamen") Integer idExamen);

    @Query(value = "from ConsultaExamen  ce where ce.consulta.idConsulta=: idConsulta")
    List<ConsultaExamen> listarExamenesPorConsulta(@Param("idConsulta") Integer idConsulta);
}
