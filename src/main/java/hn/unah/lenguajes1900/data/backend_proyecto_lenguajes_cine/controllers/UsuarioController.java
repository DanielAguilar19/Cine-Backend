package hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.entities.Usuario;
import hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.services.impls.UsuarioServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("api/usuario")
public class UsuarioController {

@Autowired
private UsuarioServiceImpl usuarioServiceImpl;

    @PostMapping("/login")
    public Usuario login(@RequestBody Usuario usuario) {
        
        return this.usuarioServiceImpl.loginUsuario(usuario);
    }
    
    
}
