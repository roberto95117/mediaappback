package com.xocop.mediaappbackend.service.impl;

import com.xocop.mediaappbackend.model.Menu;
import com.xocop.mediaappbackend.repo.IMenu;
import com.xocop.mediaappbackend.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MenuServiceImpl implements IMenuService {

    @Autowired
    IMenu repo;

    @Override
    public List<Menu> listarMenuPorUsuario(String nombre) {
        List<Menu> menus=new ArrayList<>();
        repo    .listarMenuPorUsuario(nombre).forEach(x->{
            Menu m= new Menu();
            m.setIdMenu((Integer.parseInt(String.valueOf(x[0]))));
            m.setIcono(String.valueOf(x[1]));
            m.setNombre(String.valueOf(x[2]));
            m.setUrl(String.valueOf(x[3]));

            menus.add(m);
        });
        return menus;

    }

    @Override
    public Page<Menu> listarPaginado(Pageable pageable) {
        return  repo.findAll(pageable);
    }

    @Override
    public Menu registrar(Menu obj) {
        return this.repo.save(obj);
    }

    @Override
    public Menu modificar(Menu obj) {
        return this.repo.save(obj);
    }

    @Override
    public List<Menu> listar() {
        List<Menu> lst=this.repo.findAll();
        return  lst;
    }

    @Override
    public Menu listarPorId(Integer id) {
        Optional<Menu> op=this.repo.findById(id);
        return  op.isPresent()? op.get(): new Menu();
    }

    @Override
    public boolean eliminar(Integer id) {
        this.repo.deleteById(id);
        return true;
    }
}
