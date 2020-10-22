package com.xocop.mediaappbackend.service.impl;

import com.xocop.mediaappbackend.model.Usuario;
import com.xocop.mediaappbackend.repo.IUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioServiceImpl  implements UserDetailsService {

    @Autowired
    private IUsuario repo;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Usuario user=repo.findOneByUsername(s);
        if(user==null){
            throw  new UsernameNotFoundException(String.format("Usuario no existe",s));
        }

        List<GrantedAuthority> roles=new ArrayList<>();
        user.getRoles().forEach(rol -> {
            roles.add(new SimpleGrantedAuthority(rol.getNombre()));
        });
        UserDetails ud=new User(user.getUserName(),user.getPassword(),roles);
        return ud;
    }


}
