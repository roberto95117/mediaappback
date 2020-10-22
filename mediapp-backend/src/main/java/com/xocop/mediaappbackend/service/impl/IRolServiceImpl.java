package com.xocop.mediaappbackend.service.impl;

import com.xocop.mediaappbackend.model.Rol;
import com.xocop.mediaappbackend.repo.IRol;
import com.xocop.mediaappbackend.service.IRolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class IRolServiceImpl implements IRolService {

    @Autowired
    private IRol repo;

    @Override
    public Rol registrar(Rol obj) {
        return repo.save(obj);
    }

    @Override
    public Rol modificar(Rol obj) {
        return repo.save(obj);
    }

    @Override
    public List<Rol> listar() {
        return repo.findAll();
    }

    @Override
    public Rol listarPorId(Integer id) {
        Optional<Rol> obj=repo.findById(id);
        return obj.isPresent()? obj.get() : new Rol();
    }

    @Override
    public boolean eliminar(Integer id) {
        repo.deleteById(id);
        return true;
    }
}
