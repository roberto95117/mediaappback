package com.xocop.mediaappbackend.service.impl;

import com.xocop.mediaappbackend.model.Especialidad;
import com.xocop.mediaappbackend.repo.IEspecialidad;
import com.xocop.mediaappbackend.service.IEspecialidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EspecialidadServiceImpl implements IEspecialidadService {

    @Autowired
    private IEspecialidad repo;

    @Override
    public Especialidad registrar(Especialidad obj) {
        return repo.save(obj);
    }

    @Override
    public Especialidad modificar(Especialidad obj) {
        return repo.save(obj);
    }

    @Override
    public List<Especialidad> listar() {
        return repo.findAll();
    }

    @Override
    public Especialidad listarPorId(Integer id) {
        Optional<Especialidad> obj=repo.findById(id);
        return  obj.isPresent()? obj.get(): new Especialidad();
    }

    @Override
    public boolean eliminar(Integer id) {
        repo.deleteById(id);
        return true;
    }
}
