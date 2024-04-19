package hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.services.impls;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.entities.Asiento;
import hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.entities.Boleto;
import hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.entities.Evento;
import hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.entities.Sala;
import hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.repositories.AsientoRepository;
import hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.repositories.BoletoRepository;
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
   

    @Override
    public Boleto crearBoleto(long idEvento){
      try {
        
        int i = 0;
        Evento evento = this.eventoRepository.findById(idEvento).get();
        Sala sala = evento.getSala();
        List<Asiento> asiento  = sala.getAsientos();
        Asiento asientoActual = asiento.get(i);
        Boleto boleto = new Boleto();

        while(asientoActual.getDisponible() == 1){
            i++;
            if(i > sala.getAsientos().size()){
                break;
            }
            asientoActual=asiento.get(i);

        }
    
        boleto.setAsiento(asientoActual);

        // Modificar la disponibilidad del asiento
        asientoActual.setDisponible(0); // Cambiar disponibilidad a 0 (no disponible)
        asientoRepository.save(asientoActual); // Guardar el cambio en la base de datos

        boleto.setEvento(evento);

        // Guardar el boleto en la base de datos
        return this.boletoRepository.save(boleto);
      } catch (Exception e) {
        e.printStackTrace();
        return null;
      }
    }

    @Override
    public String eliminarBoleto(long codigoEvento) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'eliminarBoleto'");
    }
}
