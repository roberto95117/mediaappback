package com.xocop.mediaappbackend.service.impl;

import com.xocop.mediaappbackend.model.Usuario;
import com.xocop.mediaappbackend.repo.ILogin;
import com.xocop.mediaappbackend.service.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements ILoginService {

    @Autowired
    private ILogin repo;

    @Override
    public Usuario verificarNombreUsuario(String usuario) throws Exception {
        return  repo.findByUsername(usuario);
    }

    @Override
    public void cambiarClave(String clave, String nombre) {
        repo.cambiarClave(clave,nombre);
    }
}
