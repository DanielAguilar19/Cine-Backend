package hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.entities.Sala;
import hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.services.impls.SalaServiceImpl;

@RestController
@RequestMapping("api/sala")
public class SalaController {

    @Autowired
    private SalaServiceImpl salaServiceImpl;

    @PostMapping("/crear")
    public Sala crearSala(@RequestBody Sala sala) {
        return this.salaServiceImpl.crearSala(sala);
    }

    @DeleteMapping("/eliminar")
    public String eliminarSalaPorId(@RequestParam long codigoSala) {
        return this.salaServiceImpl.eliminarSalaPorId(codigoSala);
    }

    
}
