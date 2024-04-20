package hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.services;

import hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.entities.DetalleFactura;

public interface DetalleFacturaService {

    public DetalleFactura crearDetalleFactura(  long codigoFactura , long codigoEvento ,int cantidadBoletos );

 
}
