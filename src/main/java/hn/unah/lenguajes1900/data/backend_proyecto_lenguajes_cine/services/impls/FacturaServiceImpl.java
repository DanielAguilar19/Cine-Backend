package hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.services.impls;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.entities.Cliente;
import hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.entities.DetalleFactura;
import hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.entities.Factura;
import hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.repositories.ClienteRepository;
import hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.repositories.DetalleFacturaRepository;
import hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.repositories.FacturaRepository;
import hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.services.FacturaService;
import java.util.List;

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

       Cliente cliente = clienteRepository.findById(codigocliente).get();

       if(cliente == null){

        return null; 

       }

       factura.setCliente(cliente);
       double subtotal = 0;
       List<DetalleFactura> detallesFactura = factura.getDetallefactura();
       if (detallesFactura != null) {
           for (DetalleFactura detalle : detallesFactura) {
               subtotal += detalle.getSubtotal() != null ? detalle.getSubtotal() : 0;
           }
       }
   
       // Calcular el total de la compra (subtotal - descuento)
       double descuento = factura.getDescuento() != null ? factura.getDescuento() : 0; // Verificar si el descuento es nulo
       double totalCompra = subtotal - descuento;
       factura.setTotalCompra(totalCompra);

       return this.facturaRepository.save(factura);

      
    }
    
    }

    
    
