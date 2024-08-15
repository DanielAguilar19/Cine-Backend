package hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.repositories;

import org.springframework.stereotype.Repository;

import hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.entities.AsientoEvento;

import org.springframework.data.repository.CrudRepository;


@Repository
public interface AsientoEventoRepository extends CrudRepository<AsientoEvento, Long>{ 
}
