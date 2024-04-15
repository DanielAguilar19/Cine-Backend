package hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.services;

import java.util.List;

import hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.entities.Pelicula;

public interface PeliculaService {

    public Pelicula crearPelicula(Pelicula pelicula);

    public List<Pelicula> obtenerPeliculas();

    public String eliminarPeliculaPorNombre(String titulo);
}
