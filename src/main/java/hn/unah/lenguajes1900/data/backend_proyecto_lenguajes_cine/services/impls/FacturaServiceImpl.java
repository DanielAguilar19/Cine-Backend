package hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.services.impls;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.entities.Factura;
import hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.repositories.ClienteRepository;
import hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.repositories.DetalleFacturaRepository;
import hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.repositories.FacturaRepository;
import hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.services.FacturaService;


@Service
public class FacturaServiceImpl implements FacturaService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private FacturaRepository facturaRepository;
    
    @Autowired
    private DetalleFacturaRepository detalleFacturaRepository;

    @Override
    public Factura crearFactura(Factura factura, long codigocliente) {

      return null;

    }
    
    }

    
    
