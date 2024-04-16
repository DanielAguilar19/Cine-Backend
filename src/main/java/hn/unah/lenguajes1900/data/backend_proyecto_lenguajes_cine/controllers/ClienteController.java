package hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.entities.Cliente;
import hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.services.impls.ClienteServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import org.springframework.web.bind.annotation.PutMapping;





@RestController
@RequestMapping("/api/cliente")
public class ClienteController {


    @Autowired
    private ClienteServiceImpl clienteServiceImpl;

    @PostMapping("/crear")
    public Cliente crearCliente(@RequestBody Cliente cliente) {
      
         return this.clienteServiceImpl.crearCliente(cliente);
    }
    
    
    @GetMapping("/obtener")
    public List<Cliente> obtenerClientes() {
        return this.clienteServiceImpl.obtenerClientes();
    }
    
@DeleteMapping("/eliminar")
public String eliminarCliente(@RequestParam int codigoCliente) {
    return this.clienteServiceImpl.eliminarCliente(codigoCliente);
}


@PutMapping("/editar/{codigoCliente}")
public Cliente editarCliente( @PathVariable int codigoCliente, @RequestBody Cliente cliente) {
    //TODO: process POST request
    return this.clienteServiceImpl.editarCliente(codigoCliente, cliente);

}

}