package hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.controllers;

import org.springframework.web.bind.annotation.RestController;

import hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.services.impls.AsientoEventoImpl;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("api/asientoevento")
public class AsientoEventoController {
    @Autowired
    private AsientoEventoImpl asientoEventoImpl;
    
    @PutMapping("cambiar/disponible/{id}")
    public String EditarAsientoEvento(@PathVariable long id, @RequestBody boolean disponible) {
        return this.asientoEventoImpl.cambiarDisponibilidadAiento(disponible, id);
    }
}
