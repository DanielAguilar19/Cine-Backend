package hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.services.impls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.entities.Sala;
import hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.repositories.SalaRepository;
import hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.services.SalaService;

@Service
public class SalaServiceImpl implements SalaService{

    @Autowired
    private SalaRepository salaRepository;

    @Override
    public Sala crearSala(Sala sala) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'crearSala'");
    }

    @Override
    public String eliminarSalaPorId(long codigoSala) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'eliminarSalaPorId'");
    }
    
}
