package hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.entities.Asiento;
import hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.entities.Sala;

@Repository
public interface AsientoRepository extends CrudRepository<Asiento, Long>{

    Asiento findFirstBySalaAndDisponibleOrderByNumeroAsientoAsc(Sala sala, int disponible);
    
}
