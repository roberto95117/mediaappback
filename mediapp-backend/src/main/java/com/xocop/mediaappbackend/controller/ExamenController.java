package com.xocop.mediaappbackend.controller;

import com.xocop.mediaappbackend.exception.ModelNotFoundException;
import com.xocop.mediaappbackend.model.Examen;
import com.xocop.mediaappbackend.service.IExamenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/examenes")
public class ExamenController {

    @Autowired
    private IExamenService service;

    @GetMapping("/")
    public ResponseEntity<List<Examen>> litar(){
        List<Examen> list=service.listar();
        if (list.isEmpty()) throw new ModelNotFoundException("NO EXISTEN REGISTROS");
        return  new ResponseEntity<List<Examen>>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public  ResponseEntity<Examen> listarPorId(@PathVariable("id") Integer id){
        Examen obj=service.listarPorId(id);
        if(obj.getIdExamen()==null) throw  new ModelNotFoundException(("NO EXITE REGISTRO CON EL ID: "+id));
        return new ResponseEntity<Examen>(obj,HttpStatus.OK);
    }

    @PostMapping("/agregar")
    public  ResponseEntity<Examen> agregar(@Valid @RequestBody Examen obj){
        Examen ex=service.registrar(obj);
        return  new ResponseEntity<Examen>(ex,HttpStatus.CREATED);
    }

    @PutMapping("/modificar")
    public  ResponseEntity<Examen> modificar(@Valid @RequestBody Examen obj){
        Examen ex=service.modificar(obj);
        return new ResponseEntity<Examen>(ex,HttpStatus.OK);
    }

    @DeleteMapping("/eliminar/{id}")
    public  ResponseEntity<Object> eliminar(@PathVariable("id") Integer id){
        service.eliminar(id);
        return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
