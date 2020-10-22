package com.xocop.mediaappbackend.controller;

import com.xocop.mediaappbackend.model.Rol;
import com.xocop.mediaappbackend.service.IRolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roles")
public class RolController {

    @Autowired
    private IRolService service;

    @GetMapping
    public ResponseEntity<List<Rol>> listar(){
        List<Rol> lista=service.listar();
        return  new ResponseEntity<List<Rol>>(lista, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public  ResponseEntity<Rol> listarPorId(@PathVariable("id") Integer id){
        Rol obj=service.listarPorId(id);
        return  new ResponseEntity<Rol>(obj,HttpStatus.OK);
    }

    @PostMapping("/agregar")
    public  ResponseEntity<Rol> agregar(@RequestBody Rol parm1){
        Rol obj=service.registrar(parm1);
        return  new ResponseEntity<Rol>(obj,HttpStatus.CREATED);
    }

    @PutMapping("/modificar")
    public  ResponseEntity<Rol> modificar(@RequestBody Rol parm1){
        Rol obj=service.modificar(parm1);
        return  new ResponseEntity<Rol>(obj,HttpStatus.OK);
    }

    @DeleteMapping("/eliminar/{id}")
    public  ResponseEntity<Object> eliminar(@PathVariable("id") Integer id){
        service.eliminar(id);
        return  new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
    }
}
