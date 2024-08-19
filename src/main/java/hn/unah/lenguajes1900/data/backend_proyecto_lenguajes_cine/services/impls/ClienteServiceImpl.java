package hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.services.impls;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.entities.Cliente;
import hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.repositories.ClienteRepository;
import hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.services.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public Cliente crearCliente(Cliente cliente) {
        return this.clienteRepository.save(cliente);
    }

    @Override
    public List<Cliente> obtenerClientes() {
        return (List<Cliente>) this.clienteRepository.findAll();
    }

    @Override
    public Cliente editarCliente(long codigoCliente, Cliente cliente) {
        Cliente clienteActualizar = this.clienteRepository.findById(codigoCliente).orElse(null);

        if (clienteActualizar != null) {
            clienteActualizar.setNombreCompleto(cliente.getNombreCompleto());
            clienteActualizar.setFechaNacimiento(cliente.getFechaNacimiento());
            clienteActualizar.setCorreo(cliente.getCorreo());
            clienteActualizar.setContrasenia(cliente.getContrasenia());
            clienteActualizar.setTelefono(cliente.getTelefono());

            this.clienteRepository.save(clienteActualizar);
        }
        return clienteActualizar;
    }

    @Override
    public Cliente obtenerClientePorId(long codigoCliente) {
        return this.clienteRepository.findById(codigoCliente).orElse(null);
    }

    @Override
    public Cliente obtenerClientePorCorreo(@RequestParam String correo, @RequestParam String contrasenia) {
        List<Cliente> clientes = (List<Cliente>) this.clienteRepository.findAll();

        for (Cliente cliente : clientes) {
            if (cliente.getCorreo().equals(correo) && cliente.getContrasenia().equals(contrasenia)) {
                return cliente;
            }
        }
        return null;
    }
}
