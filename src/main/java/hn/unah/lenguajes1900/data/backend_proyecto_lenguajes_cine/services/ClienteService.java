package hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.services;

import java.util.List;

import hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.entities.Cliente;
import hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.entities.Usuario;

public interface ClienteService {

    public Cliente crearCliente(Cliente cliente);

    public Cliente obtenerClientePorUsuario(Usuario Usuario);

    public List<Cliente> obtenerClientes();

    public Cliente editarCliente(long codigoCliente);

    public String eliminarCliente(long codigoCliente);
    
}
