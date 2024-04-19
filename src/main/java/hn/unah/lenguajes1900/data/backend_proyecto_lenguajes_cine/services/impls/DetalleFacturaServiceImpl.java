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


@Override
public DetalleFactura crearDetalleFactura(long codigoCliente, long codigoBoleto, int cantidadBoletos,
        String numeroTarjeta) {
   
            Cliente  cliente = clienteRepository.findById(codigoCliente).get();
            if (cliente == null) {
                return null; // Manejo del caso en que no se encuentre el cliente
            }
    
            Boleto boleto = boletoRepository.findById(codigoBoleto).get();
    
            if (boleto == null) {
                return null; // Manejo del caso en que no se encuentre el boleto
            }
        
            Asiento asiento = boleto.getAsiento();
            if (asiento == null) {
                return null; // Manejo del caso en que no se encuentre el asiento
            }
        
            // Obtener la sala asociada al asiento
            Sala sala = asiento.getSala();
            if (sala == null) {
                return null; // Manejo del caso en que no se encuentre la sala
            }
        
            // Obtener el tipo de sala asociado a la sala
            TipoSala tipoSala = sala.getTipoSala();
            if (tipoSala == null) {
                return null; // Manejo del caso en que no se encuentre el tipo de sala
            }
    
            double precioSala = tipoSala.getPrecio();
            double subtotal = precioSala * cantidadBoletos;
    
            double descuento = 0.0;
        if (cantidadBoletos >= 5) {
        // Si se compran 5 o más boletos, aplicar un descuento del 10%
        descuento = subtotal * 0.10;
    }
    
    
    
    double totalConDescuento = subtotal - descuento;
    
    // Crear una nueva factura
    Factura factura = new Factura();
    factura.setCliente(cliente);
    factura.setNumeroTarjeta(numeroTarjeta); // Establecer el número de tarjeta proporcionado
    factura.setFechaCompra(LocalDate.now()); // Establecer la fecha actual
    factura.setDescuento(descuento); // Establecer el descuento aplicado
    factura.setTotalCompra(totalConDescuento); // Establecer el total con descuento como total de compra
    
    // Guardar la factura en la base de datos
    factura = facturaRepository.save(factura);
    
    // Crear un nuevo detalle de factura
    DetalleFactura detalleFactura = new DetalleFactura();
    detalleFactura.setBoleto(boleto);
    detalleFactura.setFactura(factura);
    detalleFactura.setCantidadBoletos(cantidadBoletos);
    detalleFactura.setSubtotal(subtotal);
    
    // Guardar el detalle de factura en la base de datos
    return detalleFacturaRepository.save(detalleFactura);
        }
        
}
