package com.xocop.mediaappbackend.controller;


import com.xocop.mediaappbackend.exception.ModelNotFoundException;
import com.xocop.mediaappbackend.model.Paciente;
import com.xocop.mediaappbackend.service.IPacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {
    @Autowired
    private IPacienteService service;

    @GetMapping
    public ResponseEntity<List<Paciente>> listar(){
        List<Paciente> lista=service.listar();
        return  new ResponseEntity<List<Paciente>>(lista, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public  ResponseEntity<Paciente> listarPorId(@PathVariable("id") Integer id){
        Paciente obj= service.listarPorId(id);
        if(obj.getIdPaciente()==null){
            throw new ModelNotFoundException("ID NO ENCONTRADO "+id);
        }
        return new ResponseEntity<Paciente>(obj,HttpStatus.OK);
    }

    @GetMapping("/heatoas/{id}")
    public EntityModel<Paciente> listPorIdHeat(@PathVariable("id") Integer id){
        Paciente pac=service.listarPorId(id);
        EntityModel<Paciente> obj=new EntityModel<Paciente>(pac);
        WebMvcLinkBuilder linkTo= linkTo(methodOn(this.getClass()).listarPorId(id));
        obj.add(linkTo.withRel("paciente-resource"));
        return obj;
    }

    @GetMapping("/paginado")
    public  ResponseEntity<Page<Paciente>> listarPaginado(Pageable pageable){
        Page<Paciente> pacientePage= service.listarPaginado(pageable);
        return new ResponseEntity<Page<Paciente>>(pacientePage,HttpStatus.OK);
    }

    @PostMapping("/registrar")
    public ResponseEntity<Paciente> registrar(@Valid @RequestBody Paciente obj){
        Paciente objt=service.registrar(obj);
        return  new ResponseEntity<Paciente>(objt,HttpStatus.CREATED);
    }

    @PostMapping("/registrar2")
    public ResponseEntity<Object> registrar2(@Valid @RequestBody Paciente obj){
        Paciente objt=service.registrar(obj);
        URI location= ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(objt.getIdPaciente()).toUri();
        return  ResponseEntity.created(location).build();
    }

    @PutMapping("/modificar")
    public ResponseEntity<Paciente> modificar(@Valid @RequestBody Paciente obj){
        Paciente objt=service.modificar(obj);
        return new ResponseEntity<Paciente>(objt,HttpStatus.OK);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id){
        service.eliminar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }



}
