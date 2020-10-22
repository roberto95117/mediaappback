package com.xocop.mediaappbackend.controller;

import com.xocop.mediaappbackend.dto.ConsultaExamenDTO;
import com.xocop.mediaappbackend.dto.ConsultaResumenDTO;
import com.xocop.mediaappbackend.dto.FiltroConsultaDTO;
import com.xocop.mediaappbackend.exception.ModelNotFoundException;
import com.xocop.mediaappbackend.model.Archivo;
import com.xocop.mediaappbackend.model.Consulta;
import com.xocop.mediaappbackend.service.IArchivoService;
import com.xocop.mediaappbackend.service.IConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {
    @Autowired
    private IConsultaService service;

    @Autowired
    private IArchivoService archivoService;

    @GetMapping("")
    public ResponseEntity<List<Consulta>> listar(){
        List<Consulta> lista= service.listar();
        if(lista.isEmpty()) throw  new ModelNotFoundException("Aun no hay consultas para mostrar");
        return new ResponseEntity<List<Consulta>>(lista, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public  ResponseEntity<Consulta> listarPorId(@PathVariable("id") Integer id){
        Consulta obj=service.listarPorId(id);
        if (obj.getIdConsulta()==null)throw new ModelNotFoundException("No existe informacion para el id "+ id);
        return new ResponseEntity<Consulta>(obj,HttpStatus.OK);
    }

    @PostMapping("/agregar")
    public  ResponseEntity<Consulta> agregar(@Valid @RequestBody Consulta obj){
        Consulta con=service.registrar(obj);
        return new ResponseEntity<Consulta>(con,HttpStatus.CREATED);
    }

    @PostMapping("/agregarDTO")
    public  ResponseEntity<Consulta> agregar(@Valid @RequestBody ConsultaExamenDTO obj){
        Consulta con=service.registrarDTO(obj);
        return new ResponseEntity<Consulta>(con,HttpStatus.CREATED);
    }

    @PutMapping("/modificar")
    public  ResponseEntity<Consulta> modificar(@Valid @RequestBody Consulta obj){
        Consulta con=service.modificar(obj);
        return  new ResponseEntity<>(con,HttpStatus.OK);
    }

    @DeleteMapping("/eliminar/{id}")
    public  ResponseEntity<Object> eliminar(@PathVariable("id") Integer id){
        service.eliminar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/buscar")
    public  ResponseEntity<List<Consulta>> buscar(@RequestBody FiltroConsultaDTO obj){
        List<Consulta> consultas= new ArrayList<>();
        if (obj!=null){
            if(obj.getFechaConsulta()!=null){
                consultas=service.buscarFecha(obj);
            }else{
                if(obj.getDni()!=null){
                    consultas=service.buscarDni(obj);
                }else{
                    if(obj.getNombreCompleto()!=null){
                        consultas=service.buscarNombres(obj);
                    }
                }
            }
        }
        return  new ResponseEntity<List<Consulta>>(consultas, HttpStatus.OK);
    }

    @GetMapping("/listarResumen")
    public  ResponseEntity<List<ConsultaResumenDTO>> listarResumen(){
        List<ConsultaResumenDTO> lista=new ArrayList<>();
        lista=service.listarResumen();
        return  new ResponseEntity<List<ConsultaResumenDTO>>(lista,HttpStatus.OK);
    }

    @GetMapping(value = "/generarReporte",produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public ResponseEntity<byte[]> generarReporte(){
        byte[] data=null;
        data=service.generarReporte();
        return new ResponseEntity<byte[]>(data,HttpStatus.OK);
    }

    @PostMapping(value = "/guardarArchivo", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public  ResponseEntity<Integer> guardarArchivo(@RequestParam("adjunto") MultipartFile file) throws IOException {
        int rpta=0;
        Archivo ar=new Archivo();
        ar.setFilename(file.getName());
        ar.setFiletype(file.getContentType());
        ar.setValue(file.getBytes());
        rpta=archivoService.guardar(ar);
        return new ResponseEntity<Integer>(rpta,HttpStatus.OK);
    }

    @GetMapping(value = "/leerArchivo/{idArchivo}", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public  ResponseEntity<byte[]> leerArchivo(@PathVariable("idArchivo") Integer idArchivo){
        byte[] arr=archivoService.leerArchivo(idArchivo);
        return new ResponseEntity<byte[]>(arr,HttpStatus.OK);
    }
}



