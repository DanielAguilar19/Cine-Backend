package hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.services;

import java.util.List;

import hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.entities.Compra;

public interface CompraService {

    public Compra crearCompra(Compra compra);

    public String eliminarCompraPorId(long codigoCompra);

    public List<Compra> obtenerComprasDeCliente(long codigoCliente);
    
}
