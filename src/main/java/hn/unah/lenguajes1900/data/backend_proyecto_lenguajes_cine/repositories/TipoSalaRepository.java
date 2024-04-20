package hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.entities.TipoSala;

@Repository
public interface TipoSalaRepository extends CrudRepository<TipoSala, Long>{


        Optional<TipoSala> findByDescripcion(String descripcion);

    
}
