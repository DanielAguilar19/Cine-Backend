package hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.services.impls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.entities.Asiento;
import hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.repositories.AsientoRepository;
import hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.services.AsientoService;

@Service
public class AsientoServiceImpl implements AsientoService{

    @Autowired
    private AsientoRepository asientoRepository;

    @Override
    public Asiento crearAsiento(Asiento asiento) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'crearAsiento'");
    }

    @Override
    public String eliminarAsiento(long codigoSala) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'eliminarAsiento'");
    }
    
}
