package com.xocop.mediaappbackend.repo;

import com.xocop.mediaappbackend.model.Archivo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IArchivo extends JpaRepository<Archivo,Integer> {
}
