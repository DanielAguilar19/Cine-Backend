package hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.services.impls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.entities.TipoSala;
import hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.repositories.TipoSalaRepository;
import hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.services.TipoSalaService;

@Service
public class TipoSalaServiceImpl implements TipoSalaService{

    @Autowired
    private TipoSalaRepository tipoSalaRepository;

    @Override
    public TipoSala crearTipoSala(TipoSala tipoSala) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'crearTipoSala'");
    }

    @Override
    public TipoSala editarTipoSala(String tipoSala) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'editarTipoSala'");
    }

    @Override
    public String eliminarTipoSalaPorNombre(String tipoSala) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'eliminarTipoSalaPorNombre'");
    }
    
}
