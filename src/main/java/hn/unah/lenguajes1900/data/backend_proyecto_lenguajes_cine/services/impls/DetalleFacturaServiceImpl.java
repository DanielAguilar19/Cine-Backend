package hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.services.impls;



import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.entities.Cliente;
import hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.entities.DetalleFactura;
import hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.entities.Evento;
import hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.entities.Factura;
import hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.entities.Sala;
import hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.entities.TipoSala;
import hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.repositories.ClienteRepository;
import hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.repositories.DetalleFacturaRepository;
import hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.repositories.EventoRepository;
import hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.repositories.FacturaRepository;

import hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.services.DetalleFacturaService;

@Service
public class DetalleFacturaServiceImpl implements DetalleFacturaService {

    @Autowired
    private DetalleFacturaRepository detalleFacturaRepository;



     @Autowired
    private FacturaRepository facturaRepository;
 
      @Autowired
     private EventoRepository eventoRepository;

     @Autowired
     private ClienteRepository clienteRepository;


     @Override
     public DetalleFactura crearDetalleFactura(long codigoCliente, long codigoEvento, int cantidadBoletos,
             String numeroTarjeta) {
        
                Cliente  cliente = clienteRepository.findById(codigoCliente).orElse(null);
    if (cliente == null) {
        return null; 
    }

    Evento evento = eventoRepository.findById(codigoEvento).orElse(null);

    if (evento != null) {
     
        Sala sala = evento.getSala();

        if (sala != null) {
        
            TipoSala tipoSala = sala.getTipoSala();

            if (tipoSala != null) {
               
                double precioSala = tipoSala.getPrecio();

                double subtotal = precioSala * cantidadBoletos;
                
                List<Factura> facturasCliente = cliente.getFactura();

                double descuento = 0.0;
                if (facturasCliente.size() >= 5) {
                
                cliente.setClienteFrecuente(1);
                descuento = subtotal * 0.10;
            }
            
            double totalConDescuento = subtotal - descuento;
    
            Factura factura = new Factura();

            factura.setCliente(this.clienteRepository.findById(cliente.getCodigoCliente()).get());
            factura.setNumeroTarjeta(numeroTarjeta); 
            factura.setFechaCompra(LocalDate.now()); 
            factura.setDescuento(descuento); 
            factura.setTotalCompra(totalConDescuento); 

            facturasCliente.add(factura);
            cliente.setFactura(facturasCliente);
            this.clienteRepository.save(cliente);
                
            factura = facturaRepository.save(factura);
    
            DetalleFactura detalleFactura = new DetalleFactura();

            detalleFactura.setFactura(factura);
            detalleFactura.setCantidadBoletos(cantidadBoletos);
            detalleFactura.setSubtotal(subtotal);
            
        
            return detalleFacturaRepository.save(detalleFactura);
        
            }
        }
    }
  
    // Retorno null en caso de que ninguna de las condiciones anteriores se cumpla
    return null;
     }

     }






    
        
  




        
      /*   Factura factura = facturaRepository.findById(codigoFactura).orElse(null);

        if (factura == null) {
                return null; 
            }
        Evento evento = eventoRepository.findById(codigoEvento).orElse(null);

        if (evento != null) {
         
            Sala sala = evento.getSala();

            if (sala != null) {
            
                TipoSala tipoSala = sala.getTipoSala();

                if (tipoSala != null) {
                   
                    double precioSala = tipoSala.getPrecio();

                    double subtotal = precioSala * cantidadBoletos;

                  
                    DetalleFactura detalleFactura = new DetalleFactura();
                    detalleFactura.setCantidadBoletos(cantidadBoletos);
                    detalleFactura.setSubtotal(subtotal);

                    return this.detalleFacturaRepository.save(detalleFactura);
                }
            }
        }

        // Si no se puede encontrar el evento, la sala o el tipo de sala, retornar null o manejar el error según sea necesario.
        return null;
    }*/



