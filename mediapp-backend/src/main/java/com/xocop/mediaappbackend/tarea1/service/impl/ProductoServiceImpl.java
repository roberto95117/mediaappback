package com.xocop.mediaappbackend.tarea1.service.impl;

import com.xocop.mediaappbackend.tarea1.model.Producto;
import com.xocop.mediaappbackend.tarea1.repo.IProducto;
import com.xocop.mediaappbackend.tarea1.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoServiceImpl implements IProductoService {

    @Autowired
    IProducto repo;

    @Override
    public Producto registrar(Producto obj) {
        return this.repo.save(obj);
    }

    @Override
    public Producto modificar(Producto obj) {
        return this.repo.save(obj);
    }

    @Override
    public List<Producto> listar() {
        return this.repo.findAll();
    }

    @Override
    public Producto listarPorId(Integer id) {
        Optional<Producto> tmp=repo.findById(id);
        return  tmp.isPresent()? tmp.get(): new Producto();
    }

    @Override
    public boolean eliminar(Integer id) {
        this.repo.deleteById(id);
        return true;
    }
}
