package com.xocop.mediaappbackend.repo;

import com.xocop.mediaappbackend.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
                                    //JpaRepository recibe de entrada el objeto y llave
public interface IPaciente  extends JpaRepository<Paciente,Integer> {

}
