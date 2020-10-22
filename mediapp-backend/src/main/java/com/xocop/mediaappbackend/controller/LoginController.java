package com.xocop.mediaappbackend.controller;

import com.xocop.mediaappbackend.model.ResetToken;
import com.xocop.mediaappbackend.model.Usuario;
import com.xocop.mediaappbackend.repo.IResetToken;
import com.xocop.mediaappbackend.service.ILoginService;
import com.xocop.mediaappbackend.service.IResetTokenService;
import com.xocop.mediaappbackend.util.EmailUtil;
import com.xocop.mediaappbackend.util.Mail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private ILoginService service;

    @Autowired
    private IResetTokenService tokenService;

    @Autowired
    private EmailUtil emailUtil;

    @Autowired
    private BCryptPasswordEncoder bcrypt;

    @PostMapping(value = "/enviarCorreo",consumes = MediaType.TEXT_PLAIN_VALUE)//sino se pone esto, por defecto trata de parsear a un JSON
    public ResponseEntity<Integer> enviarCorreo(@RequestBody String correo) throws Exception {
        int rpt=0;
        Usuario us=service.verificarNombreUsuario(correo);
        if(us!=null && us.getIdUsuario()>0){
            ResetToken token=new ResetToken();
            token.setToken(UUID.randomUUID().toString());
            token.setUser(us);
            token.setExpiracion(10);
            tokenService.guardar(token);

            Mail mail=new Mail();
            mail.setFrom("roberto95117@gmail.com");
            mail.setTo(us.getUserName());
            System.out.println(us.getUserName());
            mail.setSubject("RESTABLECER CONTRASENIA MEDIAPP");

            Map<String,Object> model=new HashMap<>();
            String url="http://localhost:4200/recuperar/"+ token.getToken();
            model.put("user",token.getUser().getUserName());
            model.put("resetUrl",url);
            mail.setModel(model);
            System.out.println(mail.toString());
            emailUtil.enviarMail(mail);
            rpt=1;
        }
        return  new ResponseEntity<Integer>(rpt, HttpStatus.OK);
    }

    @GetMapping(value = "/restablecer/verificar/{token}")
    public ResponseEntity<Integer> restablecerClave(@PathVariable("token") String token) {
        int rpta = 0;
        try {
            if (token != null && !token.isEmpty()) {
                ResetToken rt = tokenService.findByToken(token);
                if (rt != null && rt.getId() > 0) {
                    if (!rt.estaExpirado()) {
                        rpta = 1;
                    }
                }
            }
        } catch (Exception e) {
            return new ResponseEntity<Integer>(rpta, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Integer>(rpta, HttpStatus.OK);
    }

    @PostMapping(value = "/restablecer/{token}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> restablecerClave(@PathVariable("token") String token, @RequestBody String clave) {
        try {
            ResetToken rt = tokenService.findByToken(token);
            String claveHash = bcrypt.encode(clave);
            service.cambiarClave(claveHash, rt.getUser().getUserName());
            tokenService.elimimnar(rt);
        } catch (Exception e) {
            return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Object>(HttpStatus.OK);
    }

}
