package hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.repositories;

import org.springframework.stereotype.Repository;

import hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.entities.AsientoEvento;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


@Repository
public interface AsientoEventoRepository extends CrudRepository<AsientoEvento, Long>{ 
    List<AsientoEvento> findByEventoCodigoEventoAndDisponible(long codigoEvento, boolean disponible);
}
