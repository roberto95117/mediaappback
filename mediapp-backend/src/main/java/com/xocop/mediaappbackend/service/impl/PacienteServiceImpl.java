package com.xocop.mediaappbackend.service.impl;

import com.xocop.mediaappbackend.model.Paciente;
import com.xocop.mediaappbackend.repo.IPaciente;
import com.xocop.mediaappbackend.service.IPacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Optional;

@Service
public class PacienteServiceImpl implements IPacienteService {

    @Autowired
    private IPaciente repo;


    @Override
    public Paciente registrar(Paciente obj) {
        return repo.save(obj);
    }

    @Override
    public Paciente modificar(Paciente obj) {
        return repo.save(obj);
    }

    @Override
    public List<Paciente> listar() {
        return repo.findAll();
    }

    @Override
    public Paciente listarPorId(Integer id) {
        Optional<Paciente>  op=repo.findById(id);
        return op.isPresent() ? op.get() : new Paciente();
    }

    @Override
    public boolean eliminar(Integer id) {
        repo.deleteById(id);
        return true;
    }

    @Override
    public Page<Paciente> listarPaginado(Pageable pageable) {
        return  repo.findAll(pageable);
    }
}
