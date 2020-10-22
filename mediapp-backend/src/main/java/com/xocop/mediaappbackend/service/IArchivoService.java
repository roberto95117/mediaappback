package com.xocop.mediaappbackend.service;

import com.xocop.mediaappbackend.model.Archivo;

public interface IArchivoService {
    int guardar(Archivo archivo);
    byte[] leerArchivo(Integer idArchivo);
}
