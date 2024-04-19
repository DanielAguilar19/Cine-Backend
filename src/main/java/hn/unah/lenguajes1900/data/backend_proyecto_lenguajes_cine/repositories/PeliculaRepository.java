package hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.entities.Pelicula;

@Repository
public interface PeliculaRepository extends CrudRepository<Pelicula, Long>{

    public String deleteByTitulo(String titulo);

    boolean existsByTitulo(String titulo);

    public Pelicula findByTitulo(String titulo);

    
}
