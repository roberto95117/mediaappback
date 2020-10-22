package com.xocop.mediaappbackend.tarea1.controller;

import com.xocop.mediaappbackend.exception.ModelNotFoundException;
import com.xocop.mediaappbackend.tarea1.model.Producto;
import com.xocop.mediaappbackend.tarea1.repo.IProducto;
import com.xocop.mediaappbackend.tarea1.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private IProductoService service;

    @GetMapping
    public ResponseEntity<List<Producto>> listar(){
        List<Producto> list=this.service.listar();
        if (list.isEmpty()) throw  new ModelNotFoundException("NO EXISTEN PRODUCTOS PARA MOSTRAR");
        return new ResponseEntity<List<Producto>>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public  ResponseEntity<Producto> listarPorId(@PathVariable Integer id){
        Producto tmp= service.listarPorId(id);
        if (tmp.getIdProducto()==null) throw new ModelNotFoundException("NO EXISTEN DATOS PARA EL PRODUCTO "+ id);
        return new  ResponseEntity<Producto>(tmp,HttpStatus.OK);
    }

    @PostMapping("/agregar")
    public  ResponseEntity<Producto> agregar(@Valid @RequestBody Producto obj){
        Producto tmp=service.registrar(obj);
        return new ResponseEntity<Producto>(tmp,HttpStatus.CREATED);
    }

    @PutMapping("/modificar")
    public  ResponseEntity<Producto> modificar(@Valid @RequestBody Producto obj){
        Producto tmp=service.modificar(obj);
        return new ResponseEntity<Producto>(tmp, HttpStatus.OK);
    }

    @DeleteMapping("/eliminar/{id}")
    public  ResponseEntity<Object> eliminar(@PathVariable Integer id){
        service.eliminar(id);
        return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
