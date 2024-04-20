package hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.repositories;

import org.springframework.data.repository.CrudRepository;

import hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.entities.DetalleFactura;

import java.util.List;

public interface DetalleFacturaRepository extends CrudRepository<DetalleFactura , Long> {

    List<DetalleFactura> findAllByFacturaClienteCodigoCliente(long codigoCliente);
    
}
