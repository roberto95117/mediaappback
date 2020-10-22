package com.xocop.mediaappbackend.service.impl;

import com.xocop.mediaappbackend.model.Examen;
import com.xocop.mediaappbackend.repo.IExamen;
import com.xocop.mediaappbackend.service.IExamenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExamenServiceImpl implements IExamenService {

    @Autowired
    private IExamen repo;

    @Override
    public Examen registrar(Examen obj) {
        return  repo.save(obj);
    }

    @Override
    public Examen modificar(Examen obj) {
        return repo.save(obj);
    }

    @Override
    public List<Examen> listar() {
        return repo.findAll();
    }

    @Override
    public Examen listarPorId(Integer id) {
        Optional<Examen> obj=repo.findById(id);
        return obj.isPresent()?  obj.get():  new Examen();
    }

    @Override
    public boolean eliminar(Integer id) {
        repo.deleteById(id);
        return true;
    }
}
