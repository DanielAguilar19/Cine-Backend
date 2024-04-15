package hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.services.impls;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.entities.Compra;
import hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.repositories.CompraRepository;
import hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.services.CompraService;

@Service
public class CompraServiceImpl implements CompraService{

    @Autowired
    private CompraRepository compraRepository;

    @Override
    public Compra crearCompra(Compra compra) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'crearCompra'");
    }

    @Override
    public String eliminarCompraPorId(long codigoCompra) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'eliminarCompraPorId'");
    }

    @Override
    public List<Compra> obtenerComprasDeCliente(long codigoCliente) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'obtenerComprasDeCliente'");
    }
    
}
