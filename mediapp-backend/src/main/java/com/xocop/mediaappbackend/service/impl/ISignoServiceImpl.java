package com.xocop.mediaappbackend.service.impl;

import com.xocop.mediaappbackend.model.Signo;
import com.xocop.mediaappbackend.repo.ISigno;
import com.xocop.mediaappbackend.service.ISignoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ISignoServiceImpl implements ISignoService {

    @Autowired
    private ISigno repo;

    @Override
    public Signo registrar(Signo obj) {
        return  repo.save(obj);
    }

    @Override
    public Signo modificar(Signo obj) {
        return repo.save(obj);
    }

    @Override
    public List<Signo> listar() {
        return  repo.findAll();
    }

    @Override
    public Signo listarPorId(Integer id) {
        Optional<Signo> tmp= repo.findById(id);
        return  tmp.isPresent()? tmp.get(): new Signo();
    }

    @Override
    public boolean eliminar(Integer id) {
        repo.deleteById(id);
        return  true;
    }
}
