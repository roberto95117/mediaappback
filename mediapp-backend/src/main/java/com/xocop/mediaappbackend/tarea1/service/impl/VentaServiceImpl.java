package com.xocop.mediaappbackend.tarea1.service.impl;

import com.xocop.mediaappbackend.tarea1.model.Venta;
import com.xocop.mediaappbackend.tarea1.repo.IVenta;
import com.xocop.mediaappbackend.tarea1.service.IVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VentaServiceImpl implements IVentaService {

    @Autowired
    IVenta repo;

    @Override
    public Venta registrar(Venta obj) {
        obj.getDetalleVenta().forEach(detalleVenta -> {
            detalleVenta.setVenta(obj);
        });
        return repo.save(obj);
    }

    @Override
    public Venta modificar(Venta obj) {
        return repo.save(obj);
    }

    @Override
    public List<Venta> listar() {
        List<Venta> list=repo.findAll();
        return list;
    }

    @Override
    public Venta listarPorId(Integer id) {
        Optional<Venta> obj= repo.findById(id);
        return obj.isPresent()? obj.get(): new Venta();
    }

    @Override
    public boolean eliminar(Integer id) {
        repo.deleteById(id);
        return true;
    }
}
