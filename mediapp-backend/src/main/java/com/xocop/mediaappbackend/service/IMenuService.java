package com.xocop.mediaappbackend.service;

import com.xocop.mediaappbackend.model.Menu;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IMenuService extends  ICRUD<Menu,Integer> {
    List<Menu> listarMenuPorUsuario(String nombre);
    Page<Menu> listarPaginado(Pageable pageable);
}
