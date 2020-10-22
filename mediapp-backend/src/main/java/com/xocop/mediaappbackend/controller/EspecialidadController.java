package com.xocop.mediaappbackend.controller;

import com.xocop.mediaappbackend.exception.ModelNotFoundException;
import com.xocop.mediaappbackend.model.Especialidad;
import com.xocop.mediaappbackend.service.IEspecialidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/especialidades")
public class EspecialidadController {

    @Autowired
    private IEspecialidadService service;

    @GetMapping
    public ResponseEntity<List<Especialidad>> lista(){
        List<Especialidad> list=service.listar();
        if (list.isEmpty()) throw  new ModelNotFoundException("no exsten registros");
        return  new ResponseEntity<List<Especialidad>>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public  ResponseEntity<Especialidad> listarPorId(@PathVariable("id") Integer id){
        Especialidad obj=service.listarPorId(id);
        if (obj.getIdEspecialidad()==null) throw new ModelNotFoundException(("no exite registro con el id: "+id));
        return  new ResponseEntity<Especialidad>(obj,HttpStatus.OK);
    }

    @PostMapping("/agregar")
    public  ResponseEntity<Especialidad> agregar(@Valid @RequestBody Especialidad obj){
        Especialidad esp=service.registrar(obj);
        return  new ResponseEntity<Especialidad>(esp,HttpStatus.CREATED);
    }

    @PutMapping("/modificar")
    public  ResponseEntity<Especialidad> modificar(@Valid @RequestBody Especialidad obj){
        Especialidad esp=service.modificar(obj);
        return  new ResponseEntity<Especialidad>(esp,HttpStatus.OK);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id){
        service.eliminar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
