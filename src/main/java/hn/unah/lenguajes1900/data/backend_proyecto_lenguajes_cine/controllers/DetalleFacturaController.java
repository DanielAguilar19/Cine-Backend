package hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.entities.DetalleFactura;

import hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.services.impls.DetalleFacturaServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;



@RestController
@RequestMapping("/api/detallefactura")
public class DetalleFacturaController {



    @Autowired
    private DetalleFacturaServiceImpl detalleFacturaServiceImpl;

    @PostMapping("/crear")
    public DetalleFactura crearDetalleFactura(  @RequestParam long codigoCliente, @RequestParam long codigoEvento , @RequestParam int cantidadBoletos, @RequestParam String numeroTarjeta ) {
        
        
        return this.detalleFacturaServiceImpl.crearDetalleFactura(codigoCliente, codigoEvento, cantidadBoletos, numeroTarjeta);
    }
    

    
}
