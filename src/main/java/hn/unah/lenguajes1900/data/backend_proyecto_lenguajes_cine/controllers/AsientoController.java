package hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.entities.Asiento;
import hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.services.impls.AsientoServiceImpl;

@RestController
@RequestMapping("api/asientos")
public class AsientoController {

    @Autowired
    private AsientoServiceImpl asientoServiceImpl;

    @GetMapping("/obtener")
    public List<Asiento> findAllByCodigoSala(@RequestParam long codigoSala) {
        return this.asientoServiceImpl.findAllByCodigoSala(codigoSala);
    }

    /*
    @DeleteMapping("/eliminar")
    public String eliminarAsientos(@RequestParam long codigoSala) {
        return this.asientoServiceImpl.eliminarAsientos(codigoSala);
    }
    */
    
}
