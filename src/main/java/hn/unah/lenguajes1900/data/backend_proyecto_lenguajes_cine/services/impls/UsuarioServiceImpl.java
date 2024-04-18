package hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.services.impls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.entities.Usuario;
import hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.repositories.UsuarioRepository;
import hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.services.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService{

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public Usuario crearCliente(Usuario usuario) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'crearCliente'");
    }

    @Override
    public Usuario editarUsuario(long codigoCliente) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'editarUsuario'");
    }

    @Override
    public String eliminarUsuarioPorIdCliente(long codigoCliente) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'eliminarUsuarioPorIdCliente'");
    }
    

    @Override
    public Usuario loginUsuario(Usuario usuario) {
        Usuario usuarioEncontrado = usuarioRepository.findByCorreoAndContrasenia(usuario.getCorreo(), usuario.getContrasenia());
        if (usuarioEncontrado != null) {
            return usuarioEncontrado;
        } 
        return null;
    }

    }

