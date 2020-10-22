package com.xocop.mediaappbackend.tarea1.controller;

import com.xocop.mediaappbackend.exception.ModelNotFoundException;
import com.xocop.mediaappbackend.tarea1.model.Persona;
import com.xocop.mediaappbackend.tarea1.service.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/personas")
public class PersonaController {

    @Autowired
    private IPersonaService service;

    @GetMapping
    public ResponseEntity<List<Persona>> listar(){
        List<Persona> lista=this.service.listar();
        if(lista.isEmpty())throw  new ModelNotFoundException("AUN NO HAY REGISTROS PARA MOSTRAR");
        return new ResponseEntity<List<Persona>>(lista, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public  ResponseEntity<Persona> listar(@PathVariable Integer id){
        Persona tmp=this.service.listarPorId(id);
        if (tmp.getIdPersona()==null) throw  new ModelNotFoundException("NO SE ENCONTRO INFORMACION");
        return  new ResponseEntity<>(tmp,HttpStatus.OK);
    }

    @PostMapping("/registrar")
    public ResponseEntity<Persona> agregar(@Valid @RequestBody Persona obj){
        Persona tmp=this.service.registrar(obj);
        return new ResponseEntity<Persona>(tmp,HttpStatus.CREATED);
    }

    @PutMapping("/modificar")
    public  ResponseEntity<Persona> modificar(@Valid @RequestBody Persona obj){
        Persona tmp=this.service.modificar(obj);
        return  new ResponseEntity<>(tmp,HttpStatus.OK);
    }

    @DeleteMapping("/eliminar/{id}")
    public  ResponseEntity<Object> eliminar(@PathVariable Integer id){
        this.service.eliminar(id);
        return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
