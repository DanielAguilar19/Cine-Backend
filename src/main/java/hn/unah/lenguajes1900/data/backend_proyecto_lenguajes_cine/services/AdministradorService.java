package hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.services;

import java.util.List;

import org.springframework.stereotype.Service;

import hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.entities.Administrador;

@Service
public interface AdministradorService {
    public Administrador crearAdministrador(Administrador admin);

    public List<Administrador> obtenerAdministradores();

    public Administrador obtenerAdministradorPorId(long codigoAdmin);

    public Administrador obteneAdministradorPorCorreo(String correo, String contrasenia);

    public Administrador editarAdmin(long codigoAdmin, Administrador adminEdit);
}
