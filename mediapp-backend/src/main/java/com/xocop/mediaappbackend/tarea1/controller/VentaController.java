package com.xocop.mediaappbackend.tarea1.controller;

import com.xocop.mediaappbackend.exception.ModelNotFoundException;
import com.xocop.mediaappbackend.tarea1.model.Venta;
import com.xocop.mediaappbackend.tarea1.service.IVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/ventas")
public class VentaController {

    @Autowired
    IVentaService service;

    @GetMapping("/")
    public ResponseEntity<List<Venta>>  litar(){
        List<Venta> list=service.listar();
        if (list.isEmpty()) throw  new ModelNotFoundException("AUN NO HAY REGISTROS PARA MOSTRAR");
        return  new ResponseEntity<List<Venta>>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public  ResponseEntity<Venta> listarPorId(@PathVariable Integer id){
        Venta tmp=service.listarPorId(id);
        if(tmp.getIdVenta()==null) throw new ModelNotFoundException("NO EXISTE REGISTRO CON EL ID " + id);
        return  new ResponseEntity<Venta>(tmp,HttpStatus.OK);
    }

    @PostMapping("/agregar")
    public  ResponseEntity<Venta> agregar(@Valid @RequestBody Venta obj){
        Venta tmp=service.registrar(obj);
        return  new ResponseEntity<Venta>(tmp,HttpStatus.CREATED);
    }

    @PutMapping("/modificar")
    public  ResponseEntity<Venta> modificar(@Valid @RequestBody Venta obj){
        Venta tmp=service.modificar(obj);
        return  new ResponseEntity<Venta>(tmp,HttpStatus.OK);
    }

    @DeleteMapping("/eliminar/{id}")
    public  ResponseEntity<Object> eliminar(@PathVariable  Integer id){
        service.eliminar(id);
        return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
