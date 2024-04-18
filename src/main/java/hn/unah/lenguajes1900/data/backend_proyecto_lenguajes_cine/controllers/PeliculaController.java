package hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.entities.Pelicula;
import hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.services.impls.PeliculaServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api/pelicula")
public class PeliculaController {

    @Autowired
    private PeliculaServiceImpl peliculaServiceImpl;

    @PostMapping("/crear")
    public Pelicula crearPelicula(@RequestBody Pelicula pelicula) {        
        return this.peliculaServiceImpl.crearPelicula(pelicula);
    }
    
    @GetMapping("/obtener")
    public List<Pelicula> obtenerPeliculas() {
        return this.peliculaServiceImpl.obtenerPeliculas();
    }

    @DeleteMapping("/eliminar")
    public String eliminarPeliculaByTitulo(@RequestParam String titulo) {
        return this.peliculaServiceImpl.eliminarPeliculaPorNombre(titulo);
    }
    

}
