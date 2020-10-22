package com.xocop.mediaappbackend.service;

import com.xocop.mediaappbackend.model.Usuario;

public interface ILoginService {
    Usuario verificarNombreUsuario(String usuario) throws  Exception;
    void cambiarClave(String clave,String nombre);
}
