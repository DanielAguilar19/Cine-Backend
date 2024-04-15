package hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.services.impls;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.entities.Pelicula;
import hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.repositories.PeliculaRepository;
import hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.services.PeliculaService;

@Service
public class PeliculaServiceImpl implements PeliculaService{

    @Autowired
    private PeliculaRepository peliculaRepository;

    @Override
    public Pelicula crearPelicula(Pelicula pelicula) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'crearPelicula'");
    }

    @Override
    public List<Pelicula> obtenerPeliculas() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'obtenerPeliculas'");
    }

    @Override
    public String eliminarPeliculaPorNombre(String titulo) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'eliminarPeliculaPorNombre'");
    }
    
}
