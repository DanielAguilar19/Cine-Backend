package hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.entities.Boleto;

import hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.services.impls.BoletoServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;



@RestController
@RequestMapping("/api/boleto")
public class BoletoController {
    
    @Autowired
    private BoletoServiceImpl boletoServiceImpl;

    @PostMapping("/crear")
    public Boleto crearBoleto(@RequestParam long idEvento, @RequestParam long idAsiento,  @RequestParam long codigoDetalleFactura) {
        
        return this.boletoServiceImpl.crearBoleto(idEvento, idAsiento, codigoDetalleFactura);
    }

    @GetMapping("/obtenerPorEvento")
    public List<Boleto> obtenerPorIdEvento(long codigoEvento){

        return this.boletoServiceImpl.obtenerPorIdEvento(codigoEvento);
    }

    
}
