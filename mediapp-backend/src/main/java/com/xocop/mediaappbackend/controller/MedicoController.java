package com.xocop.mediaappbackend.controller;


import com.xocop.mediaappbackend.exception.ModelNotFoundException;
import com.xocop.mediaappbackend.model.Medico;
import com.xocop.mediaappbackend.service.IMedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private IMedicoService service;

//    @PreAuthorize("@authServiceImpl.tieneAcceso('listar')")
//    @PreAuthorize("hasAuthority('ADMIN') OR hasAuthority('USER')")
    @GetMapping
    public ResponseEntity<List<Medico>> listar(){
        List<Medico> lista=service.listar();
        if (lista.isEmpty())throw new ModelNotFoundException("NO EXISTEN MEDICOS AUN");
        return  new ResponseEntity<List<Medico>>(lista,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public  ResponseEntity<Medico> listarPorId(@PathVariable("id") Integer id){
        Medico obj = service.listarPorId(id);
        if (obj.getIdMedico()==null){
            throw new ModelNotFoundException("ID NO ENCONTRADO" + id);
        }
        return new ResponseEntity<Medico>(obj,HttpStatus.OK);
    }

    @PostMapping("/agregar")
    public ResponseEntity<Medico> agregar(@Valid @RequestBody Medico obj ){
        Medico med=service.registrar(obj);
        return  new ResponseEntity<Medico>(med,HttpStatus.CREATED);
    }


    @PutMapping("/modificar")
    public  ResponseEntity<Medico> modificar(@Valid @RequestBody Medico obj){
        Medico med=service.modificar(obj);
        return  new ResponseEntity<Medico>(med,HttpStatus.OK);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id){
        service.eliminar(id);
        return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
