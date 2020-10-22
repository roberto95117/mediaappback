package com.xocop.mediaappbackend.controller;

import java.util.ArrayList;
import java.util.List;

import com.xocop.mediaappbackend.model.Menu;
import com.xocop.mediaappbackend.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/menus")
public class MenuController {
	
	@Autowired
	private IMenuService service;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Menu>> listar() {
		List<Menu> menus = new ArrayList<>();
		menus = service.listar();
		return new ResponseEntity<List<Menu>>(menus, HttpStatus.OK);
	}

	@GetMapping("/paginado")
	public  ResponseEntity<Page<Menu>> listarPaginado(Pageable pageable){
		Page<Menu> paginado=service.listarPaginado(pageable);
		return  new ResponseEntity<Page<Menu>>(paginado,HttpStatus.OK);
	}
	
	@PostMapping(value = "/usuario", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Menu>> listar(@RequestBody String nombre) {
		List<Menu> menus = new ArrayList<>();
		menus = service.listarMenuPorUsuario(nombre);
		return new ResponseEntity<List<Menu>>(menus, HttpStatus.OK);
	}

	@PostMapping(value = "/agregar")
	public  ResponseEntity<Menu> agregar(@RequestBody Menu obj){
		Menu m=service.registrar(obj);
		return new ResponseEntity<Menu>(m,HttpStatus.CREATED);
	}

	@PutMapping("/modificar")
	public  ResponseEntity<Menu> modificar(@RequestBody Menu obj){
		Menu m=service.modificar(obj);
		return new ResponseEntity<Menu>(m,HttpStatus.OK);
	}

	@DeleteMapping("/eliminar/{id}")
	public  ResponseEntity<Object> eliminar(@PathVariable("id") Integer id){
		service.eliminar(id);
		return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
	}
}
