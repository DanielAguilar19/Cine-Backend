package hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.services.impls;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.entities.Pelicula;
import hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.repositories.PeliculaRepository;
import hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.services.PeliculaService;
import jakarta.transaction.Transactional;

@Service
public class PeliculaServiceImpl implements PeliculaService{

    @Autowired
    private PeliculaRepository peliculaRepository;

    @Override
    public Pelicula crearPelicula(Pelicula pelicula) {
        return this.peliculaRepository.save(pelicula);
    }

    @Override
    public List<Pelicula> obtenerPeliculas() {
        return (List<Pelicula>) this.peliculaRepository.findAll();
    }

    @Transactional
    public String eliminarPeliculaPorNombre(String titulo) {
        if (this.peliculaRepository.existsByTitulo(titulo)) {
            this.peliculaRepository.deleteByTitulo(titulo);
            return "Película eliminada";
        } else {
            return "No existe la película";
        }
    }
    
}
