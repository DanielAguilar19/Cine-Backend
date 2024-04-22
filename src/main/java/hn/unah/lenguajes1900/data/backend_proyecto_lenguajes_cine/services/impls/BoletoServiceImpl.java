package hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.services.impls;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.entities.Asiento;
import hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.entities.Boleto;
import hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.entities.DetalleFactura;
import hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.entities.Evento;
import hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.repositories.AsientoRepository;
import hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.repositories.BoletoRepository;
import hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.repositories.DetalleFacturaRepository;
import hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.repositories.EventoRepository;
import hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.services.BoletoService;

@Service
public class BoletoServiceImpl implements BoletoService{

    @Autowired
    private BoletoRepository boletoRepository;

    @Autowired
    private AsientoRepository asientoRepository;

    @Autowired
    private EventoRepository eventoRepository;
    
    @Autowired
    private DetalleFacturaRepository detalleFacturaRepository;


@Override
public Boleto crearBoleto(long idEvento, long idAsiento, long codigoDetalleFactura) {
  if(this.eventoRepository.existsById(idEvento) && this.asientoRepository.existsById(idAsiento)){

    Evento evento = this.eventoRepository.findById(idEvento).get();
    Asiento asiento = this.asientoRepository.findById(idAsiento).get();
    DetalleFactura detalleFactura = this.detalleFacturaRepository.findById(codigoDetalleFactura).get();

    List<Boleto> boletos = (List<Boleto>) this.boletoRepository.findAll();
    List<Boleto> boletosAsiento = asiento.getBoletos();

    for (Boleto boletoI : boletos) {
      if(boletoI.getEvento().getCodigoEvento() == evento.getCodigoEvento() && boletoI.getAsiento().getCodigoAsiento() == asiento.getCodigoAsiento()){
        System.out.println("El asiento en este evento ya está ocupado");
        return null;
      }
      if(boletoI.getAsiento().getCodigoAsiento() == idAsiento){
        boletosAsiento.add(boletoI);
      }
    }

      asiento.setBoletos(boletosAsiento);
      this.asientoRepository.save(asiento);

      Boleto boleto = new Boleto();
      boleto.setEvento(evento);
      boleto.setAsiento(this.asientoRepository.findById(idAsiento).get());
      boleto.setDetallefactura(detalleFactura);

      
      return this.boletoRepository.save(boleto);
  }
  System.out.println("No existe el evento o el asiento.");
  return null;
}

public List<Boleto> obtenerPorIdEvento(long codigoEvento){

  if(this.eventoRepository.existsById(codigoEvento)){

    List<Boleto> boletosEvento = new ArrayList<>();
    List<Boleto> boletosDB = (List<Boleto>) this.boletoRepository.findAll();

    for (Boleto boleto : boletosDB) {
      
      if(boleto.getEvento().getCodigoEvento() == codigoEvento){

        boletosEvento.add(boleto);
      }
      
    }

    return boletosEvento;
  }
  System.out.println("El evento no existe en la base de datos.");
  return null;
}

}
  

    

    
