package hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;




import org.springframework.web.bind.annotation.RestController;

import hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.entities.Administrador;
import hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.services.impls.AdministradorImpl;

import java.util.List;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/api/administrador")
public class AdministradorController {

    @Autowired
    private AdministradorImpl adminServiceImpl;

    @PostMapping("/crear")
    public Administrador crearAdministrador(@RequestBody Administrador Administrador) {
        return this.adminServiceImpl.crearAdministrador(Administrador);
    }
    
    @GetMapping("/obtener")
    public List<Administrador> obtenerAdministradors() {
        return this.adminServiceImpl.obtenerAdministradores();
    }
    
    @PutMapping("/editar/{codigoAdministrador}")
    public Administrador editarAdministrador(@PathVariable long codigoAdministrador, @RequestBody Administrador Administrador) {
        return this.adminServiceImpl.editarAdmin(codigoAdministrador, Administrador);

    }

    @GetMapping("/obtenerPorId")
    public Administrador obtenerAdministradorPorId(@RequestParam long codigoAdministrador) {
        return this.adminServiceImpl.obtenerAdministradorPorId(codigoAdministrador);
    }

    @GetMapping("/obtenerPorCorreo")
    public Administrador obtenerAdministradorPorCorreo(String correo, String contrasenia) {
        return this.adminServiceImpl.obteneAdministradorPorCorreo(correo, contrasenia);
    }

}