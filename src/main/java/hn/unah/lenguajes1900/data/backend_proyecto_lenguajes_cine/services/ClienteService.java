package hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.services;

import java.util.List;

import hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.entities.Cliente;


public interface ClienteService {

    public Cliente crearCliente(Cliente cliente);

    public List<Cliente> obtenerClientes();

    public Cliente editarCliente(long codigoCliente , Cliente cliente);

    public String eliminarCliente(long codigoCliente);
    
}
