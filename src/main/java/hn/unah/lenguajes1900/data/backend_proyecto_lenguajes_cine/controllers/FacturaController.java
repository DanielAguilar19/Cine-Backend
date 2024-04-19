package hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.entities.Factura;
import hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.services.impls.FacturaServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/factura")
public class FacturaController {
    
    @Autowired
    private FacturaServiceImpl facturaServiceImpl;

    @PostMapping("/crear")
    public Factura crearFactura(@RequestBody Factura factura, @RequestParam long codigoCliente) {
        //TODO: process POST request
        
        return this.facturaServiceImpl.crearFactura(factura, codigoCliente);
    }
    
    
}
