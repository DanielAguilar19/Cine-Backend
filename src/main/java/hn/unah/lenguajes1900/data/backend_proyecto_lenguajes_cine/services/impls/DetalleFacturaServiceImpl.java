package hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.services.impls;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.entities.Asiento;
import hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.entities.Boleto;
import hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.entities.Cliente;
import hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.entities.DetalleFactura;
import hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.entities.Factura;
import hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.entities.Sala;
import hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.entities.TipoSala;
import hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.repositories.BoletoRepository;
import hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.repositories.ClienteRepository;
import hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.repositories.DetalleFacturaRepository;
import hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.repositories.FacturaRepository;   

import hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.services.DetalleFacturaService;

@Service
public class DetalleFacturaServiceImpl implements DetalleFacturaService {

    @Autowired
    private DetalleFacturaRepository detalleFacturaRepository;

    @Autowired
    private BoletoRepository boletoRepository;

    @Autowired
    private FacturaRepository facturaRepository;

    @Autowired
    private ClienteRepository clienteRepository;

// Falta arreglar esto
@Override
public DetalleFactura crearDetalleFactura(long codigoCliente, long codigoBoleto, int cantidadBoletos,
        String numeroTarjeta) {

            Cliente  cliente = clienteRepository.findById(codigoCliente).get();
            if (cliente == null) {
                return null; 
            }
    
            Boleto boleto = boletoRepository.findById(codigoBoleto).get();
    
            if (boleto == null) {
                return null; 
            }
        
            Asiento asiento = boleto.getAsiento();
            if (asiento == null) {
                return null; 
            }
        
        
            Sala sala = asiento.getSala();
            if (sala == null) {
                return null; 
            }
        
        
            TipoSala tipoSala = sala.getTipoSala();
            if (tipoSala == null) {
                return null; 
            }
    
            double precioSala = tipoSala.getPrecio();
            double subtotal = precioSala * cantidadBoletos;
    
            double descuento = 0.0;
        if (cantidadBoletos >= 5) {
        
        descuento = subtotal * 0.10;
    }
    
    
    
    double totalConDescuento = subtotal - descuento;
    
    
    Factura factura = new Factura();
    factura.setCliente(cliente);
    factura.setNumeroTarjeta(numeroTarjeta); 
    factura.setFechaCompra(LocalDate.now()); 
    factura.setDescuento(descuento); 
    factura.setTotalCompra(totalConDescuento); 
    

    factura = facturaRepository.save(factura);
    
    
    DetalleFactura detalleFactura = new DetalleFactura();
    detalleFactura.setBoleto(boleto);
    detalleFactura.setFactura(factura);
    detalleFactura.setCantidadBoletos(cantidadBoletos);
    detalleFactura.setSubtotal(subtotal);
    

    return detalleFacturaRepository.save(detalleFactura);
        }
        
}
