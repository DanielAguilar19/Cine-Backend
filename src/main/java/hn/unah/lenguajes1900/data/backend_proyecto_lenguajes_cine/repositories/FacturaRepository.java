package hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.repositories;

import org.springframework.data.repository.CrudRepository;

import hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.entities.Factura;

public interface FacturaRepository extends CrudRepository<Factura , Long>{
    
}