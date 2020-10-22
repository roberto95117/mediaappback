package com.xocop.mediaappbackend.repo;

import com.xocop.mediaappbackend.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUsuario extends JpaRepository<Usuario,Integer> {
    Usuario findOneByUsername(String username);
}
