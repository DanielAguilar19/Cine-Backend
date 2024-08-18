package hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.entities.Asiento;
import hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.services.impls.AsientoServiceImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("api/asientos")
public class AsientoController {

    @Autowired
    private AsientoServiceImpl asientoServiceImpl;

    @PostMapping("/crear")
    public Asiento crearAsientos(@RequestBody Asiento nvAsiento) {
        return this.asientoServiceImpl.crearAsiento(nvAsiento);
    }

    @DeleteMapping("/eliminar")
    public String eliminarAsientos(@RequestParam long codigoSala) {
        return this.asientoServiceImpl.eliminarAsientos(codigoSala);
    }

    @GetMapping("/obtenerporsala/{codigoSala}")
    public List<Asiento> obtenerAsientosporSala(@PathVariable Long codigoSala) {
        return this.asientoServiceImpl.findAllByCodigoSala(codigoSala);
    }
       
}
