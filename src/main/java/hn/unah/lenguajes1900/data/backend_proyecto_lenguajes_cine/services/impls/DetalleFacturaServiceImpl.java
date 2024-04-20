package hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.services.impls;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.entities.DetalleFactura;
import hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.entities.Evento;
import hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.entities.Factura;
import hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.entities.Sala;
import hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.entities.TipoSala;

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

     @Override
     public DetalleFactura crearDetalleFactura(long codigoFactura, long codigoEvento, int cantidadBoletos) {
        
        Factura factura = facturaRepository.findById(codigoFactura).orElse(null);

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
    }

     }



