package hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.entities.Factura;
import hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.services.impls.FacturaServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;



@RestController
@RequestMapping("/api/factura")
public class FacturaController {
    
    @Autowired
    private FacturaServiceImpl facturaServiceImpl;

    @PostMapping("/crear")
    public Factura crearFactura(@RequestParam long codigoCliente, @RequestParam String numeroTarjeta) {
        return this.facturaServiceImpl.crearFactura(codigoCliente, numeroTarjeta);
    }
    
    
}
