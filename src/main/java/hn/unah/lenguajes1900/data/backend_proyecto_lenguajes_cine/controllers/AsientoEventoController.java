package hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.controllers;

import org.springframework.web.bind.annotation.RestController;

import hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.entities.AsientoEvento;
import hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.services.impls.AsientoEventoImpl;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("api/asientoevento")
public class AsientoEventoController {
    @Autowired
    private AsientoEventoImpl asientoEventoImpl;
    
    @PutMapping("cambiar/disponible/{id}")
    public String EditarAsientoEvento(@PathVariable long codigoAsientoEvento, @RequestBody boolean disponible) {
        return this.asientoEventoImpl.cambiarDisponibilidadAiento(disponible, codigoAsientoEvento);
    }

    @GetMapping("/libres/{eventoId}")
    public List<AsientoEvento> getAsientosLibres(@PathVariable long eventoId) {
        return asientoEventoImpl.asientosLibresPorEvento(eventoId);
    }

    @GetMapping("/ocupados/{eventoId}")
    public List<AsientoEvento> getAsientosOcupados(@PathVariable long eventoId) {
        return asientoEventoImpl.asientosOcupadosPorEvento(eventoId);
    }
}
//http://localhost:8080/api/asientoevento/libres/{eventoId}