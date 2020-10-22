package com.xocop.mediaappbackend.tarea1.repo;

import com.xocop.mediaappbackend.tarea1.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPersona extends JpaRepository<Persona,Integer> {

}
