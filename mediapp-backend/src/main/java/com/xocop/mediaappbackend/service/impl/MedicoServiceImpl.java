package com.xocop.mediaappbackend.service.impl;

import com.xocop.mediaappbackend.model.Medico;
import com.xocop.mediaappbackend.repo.IMedico;
import com.xocop.mediaappbackend.service.IMedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicoServiceImpl implements IMedicoService {
    @Autowired
    private IMedico repo;

    @Override
    public Medico registrar(Medico obj) {
        return  repo.save(obj);
    }

    @Override
    public Medico modificar(Medico obj) {
        return repo.save(obj);
    }

    @Override
    public List<Medico> listar() {
        return repo.findAll();
    }

    @Override
    public Medico listarPorId(Integer id) {
        Optional<Medico> op=repo.findById(id);
        return op.isPresent() ? op.get():new Medico();
    }

    @Override
    public boolean eliminar(Integer id) {
        repo.deleteById(id);
        return true;
    }
}
