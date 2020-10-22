package com.xocop.mediaappbackend.controller;

import com.xocop.mediaappbackend.model.ConsultaExamen;
import com.xocop.mediaappbackend.repo.IConsultaExamen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/consultaexamenes")
public class ConsultaExamenController  {

    @Autowired
    private IConsultaExamen service;

    @GetMapping("/{idConsulta}")
    public ResponseEntity<List<ConsultaExamen>> listar(@RequestParam("idConsulta") Integer idConsulta){
        List<ConsultaExamen> lista=new ArrayList<>();
        lista=service.listarExamenesPorConsulta(idConsulta);
        return  new ResponseEntity<List<ConsultaExamen>>(lista, HttpStatus.OK);
    }
}
