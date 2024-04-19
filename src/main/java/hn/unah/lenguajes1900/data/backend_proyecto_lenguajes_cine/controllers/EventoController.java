package hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.entities.Evento;
import hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.services.impls.EventoServiceImpl;

@RestController
@RequestMapping("api/evento")
public class EventoController {

    @Autowired
    private EventoServiceImpl eventoServiceImpl;

    @PostMapping("/crear")
    public Evento crearEvento(@RequestBody Evento evento ,@RequestParam long codigopelicula, @RequestParam long codigosala) {
        return this.eventoServiceImpl.crearEvento(evento, codigopelicula, codigosala);
    }

    @GetMapping("/obtener")
    public List<Evento> obtenerEventos() {
        return this.eventoServiceImpl.obtenerEventos();
    }

    @GetMapping("/obtenerPorFecha")
    public List<Evento> obtenerEventosPorFecha(@RequestParam LocalDate fechaInicio, @RequestParam LocalDate fechaFinal) {
        return this.eventoServiceImpl.obtenerEventosPorFecha(fechaInicio, fechaFinal);
    }

    @GetMapping("/obtenerPorNombre")
    public List<Evento> obtenerEventosPorNombre(@RequestParam String titulo) {
        return this.eventoServiceImpl.obtenerEventosPorNombre(titulo);
    }

    @DeleteMapping("/eliminarPorId")
    public String eliminarEventoPorId(@RequestParam long codigoEvento) {
        return this.eventoServiceImpl.eliminarEventoPorId(codigoEvento);
    }

    @DeleteMapping("/eliminarPorNombre")
    public String eliminarEventosPorNombre(@RequestParam String titulo) {
        return this.eventoServiceImpl.eliminarEventosPorNombre(titulo);
    }

    @PutMapping("/editar")
    public Evento editarEvento(@RequestParam long codigoEvento, @RequestBody Evento evento) {
        return this.eventoServiceImpl.editarEvento(codigoEvento, evento);
    }
    
    
}
