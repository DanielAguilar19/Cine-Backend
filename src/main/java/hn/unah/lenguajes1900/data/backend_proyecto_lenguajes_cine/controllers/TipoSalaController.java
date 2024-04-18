package hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.entities.TipoSala;
import hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.services.impls.TipoSalaServiceImpl;

@RestController
@RequestMapping("/api/tipoSala")
public class TipoSalaController {

    @Autowired
    private TipoSalaServiceImpl tipoSalaServiceImpl;


    @PostMapping("/crear")
    public TipoSala crearTipoSala(@RequestBody TipoSala tipoSala) {
        return this.tipoSalaServiceImpl.crearTipoSala(tipoSala);
    }

    @PutMapping("/editar/{codigoTipoSala}")
    public String editarTipoSala(@PathVariable int codigoTipoSala, @RequestBody TipoSala tipoSala) {
        return this.tipoSalaServiceImpl.editarTipoSala(codigoTipoSala, tipoSala);
    }

    @DeleteMapping("/eliminar")
    public String eliminarTipoSalaPorNombre(@RequestParam String nombreTipoSala) {
        return this.tipoSalaServiceImpl.eliminarTipoSalaPorNombre(nombreTipoSala);
        
    }

    
}
