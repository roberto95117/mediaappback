package com.xocop.mediaappbackend.tarea1.service.impl;

import com.xocop.mediaappbackend.tarea1.model.Persona;
import com.xocop.mediaappbackend.tarea1.repo.IPersona;
import com.xocop.mediaappbackend.tarea1.service.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaServiceImpl implements IPersonaService {

    @Autowired
    IPersona repo;

    @Override
    public Persona registrar(Persona obj) {
        return  this.repo.save(obj);
    }

    @Override
    public Persona modificar(Persona obj) {
        return  this.repo.save(obj);
    }

    @Override
    public List<Persona> listar() {
        return  this .repo.findAll();
    }

    @Override
    public Persona listarPorId(Integer id) {
        Optional<Persona> obj=this.repo.findById(id);
        return  obj.isPresent()? obj.get():new Persona();
    }

    @Override
    public boolean eliminar(Integer id) {
        this.repo.deleteById(id);
        return true;
    }
}
