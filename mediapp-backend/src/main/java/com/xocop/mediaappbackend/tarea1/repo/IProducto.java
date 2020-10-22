package com.xocop.mediaappbackend.tarea1.repo;

import com.xocop.mediaappbackend.tarea1.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProducto extends JpaRepository<Producto,Integer> {
}
