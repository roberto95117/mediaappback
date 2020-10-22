package com.xocop.mediaappbackend.controller;

import com.xocop.mediaappbackend.exception.ModelNotFoundException;
import com.xocop.mediaappbackend.model.Signo;
import com.xocop.mediaappbackend.service.ISignoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/signos")
public class SignoController {

    @Autowired
    private ISignoService service;

    @GetMapping
    public ResponseEntity<List<Signo>> listar(){
        List<Signo> list=service.listar();
        if (list.isEmpty()) throw new  ModelNotFoundException("AUN NO HAY REGISTROS PARA MOSTRAR");
        return  new ResponseEntity<List<Signo>>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public  ResponseEntity<Signo> listarPorId(@PathVariable("id") Integer id){
        Signo signo=service.listarPorId(id);
        if (signo.getIdSigno()==0) throw new ModelNotFoundException("NO existe registro en el id :" +id);
        return  new ResponseEntity<Signo>(signo,HttpStatus.OK);
    }

    @PostMapping("/agregar")
    public  ResponseEntity<Signo> agregar(@Valid @RequestBody Signo obj){
        Signo signo=service.registrar(obj);
        return  new ResponseEntity<Signo>(signo,HttpStatus.CREATED);
    }

    @PutMapping("/modificar")
    public ResponseEntity<Signo> modificar(@Valid @RequestBody Signo obj){
        Signo signo=service.modificar(obj);
        return new ResponseEntity<Signo>(signo,HttpStatus.OK);
    }

    @DeleteMapping("/eliminar/{id}")
    public  ResponseEntity<Object> eliminar(@PathVariable("id") Integer id){
        service.eliminar(id);
        return  new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
    }

}
