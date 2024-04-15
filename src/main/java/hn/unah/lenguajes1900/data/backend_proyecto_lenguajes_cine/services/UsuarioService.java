package hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.services;

import hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.entities.Usuario;

public interface UsuarioService {
    
    public Usuario crearCliente(Usuario usuario);

    public Usuario editarUsuario(long codigoCliente);

    public String eliminarUsuarioPorIdCliente(long codigoCliente);

}
