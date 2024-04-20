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

import java.time.LocalDate;
import java.util.List;


// Falt arreglar esto
@Service
public class FacturaServiceImpl implements FacturaService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private FacturaRepository facturaRepository;
    
    @Autowired
    private DetalleFacturaRepository detalleFacturaRepository;


  @Override
  public Factura crearFactura(long codigoCliente, String numeroTarjeta) {
  
    Cliente cliente = clienteRepository.findById(codigoCliente).orElse(null);
      if (cliente != null) {
        
          List<DetalleFactura> detalles = detalleFacturaRepository.findAllByFacturaClienteCodigoCliente(codigoCliente);
          Double totalCompra = detalles.stream().mapToDouble(DetalleFactura::getSubtotal).sum();

          
          Double descuentoTotal = cliente.getFactura().stream().mapToDouble(Factura::getDescuento).sum();

            Double totalConDescuento = totalCompra - descuentoTotal;

            Factura factura = new Factura();
            factura.setCliente(cliente);
            factura.setNumeroTarjeta(numeroTarjeta); 
            factura.setTotalCompra(totalConDescuento);
            factura.setFechaCompra(LocalDate.now());
            factura.setDescuento(descuentoTotal);

     
            return facturaRepository.save(factura);
        } else {
          
            return null;
        }
    }
  }
   
    
      
  


    
    

    
    
