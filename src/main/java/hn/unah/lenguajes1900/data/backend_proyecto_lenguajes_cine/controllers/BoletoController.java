package hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.entities.Boleto;
import hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.services.impls.BoletoServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;



@RestController
@RequestMapping("/api/Boleto")
public class BoletoController {
    
  

    @Autowired
    private BoletoServiceImpl boletoServiceImpl;

    @PostMapping("/crear")
    public Boleto crearBoleto(@RequestParam long idEvento) {
       
        
        return this.boletoServiceImpl.crearBoleto(idEvento);
    }
    
}
