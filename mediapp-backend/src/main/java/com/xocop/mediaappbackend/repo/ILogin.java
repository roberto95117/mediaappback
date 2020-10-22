package com.xocop.mediaappbackend.repo;

import com.xocop.mediaappbackend.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface ILogin extends JpaRepository<Usuario, Integer> {
    Usuario findByUsername(String nombre);

    @Transactional
    @Modifying
    @Query("UPDATE Usuario  us set us.password=:clave  where us.username=:usuario")
    void cambiarClave(@Param("clave")String clave,@Param("usuario")String usuario);

}
