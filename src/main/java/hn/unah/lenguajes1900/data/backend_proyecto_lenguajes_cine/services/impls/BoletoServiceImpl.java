package hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.services.impls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.entities.Boleto;
import hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.repositories.BoletoRepository;
import hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.services.BoletoService;

@Service
public class BoletoServiceImpl implements BoletoService{

    @Autowired
    private BoletoRepository boletoRepository;

    @Override
    public Boleto crearBoleto(Boleto boleto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'crearBoleto'");
    }

    @Override
    public String eliminarBoleto(long codigoEvento) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'eliminarBoleto'");
    }
}
