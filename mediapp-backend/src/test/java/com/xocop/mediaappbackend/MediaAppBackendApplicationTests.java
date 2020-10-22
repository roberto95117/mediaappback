package com.xocop.mediaappbackend;

import com.xocop.mediaappbackend.model.Usuario;
import com.xocop.mediaappbackend.repo.IUsuario;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.junit.jupiter.api.Assertions.assertTrue;
@SpringBootTest
class MediaAppBackendApplicationTests {

    @Autowired
    private BCryptPasswordEncoder bcrypt;

    @Autowired
    private IUsuario repo;



    @Test
    void crearUsuario() {
        Usuario us=new Usuario();
        us.setIdUsuario(1);
        us.setUserName("roberto95117@gmail.com");
        us.setPassword(bcrypt.encode("2012210"));
        us.setEstado(true);
        Usuario ret=repo.save(us);
        assertTrue(ret.getPassword().equalsIgnoreCase(us.getPassword()));
    }

}
