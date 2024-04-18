package hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.services.impls;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.entities.Evento;
import hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.repositories.EventoRepository;
import hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.services.EventoService;

@Service
public class EventoServiceImpl implements EventoService{

    @Autowired
    private EventoRepository eventoRepository;

    @Override
    public Evento crearEvento(Evento evento) {
        return this.eventoRepository.save(evento);
    }

    @Override
    public List<Evento> obtenerEventos() {
        return (List<Evento>) this.eventoRepository.findAll();
    }

    @Override
    public List<Evento> obtenerEventosPorFecha(LocalDate fechaInicio, LocalDate fechaFinal) {
        
        List<Evento> eventos = (List<Evento>) this.eventoRepository.findAll();

        if(!eventos.isEmpty()){
            List<Evento> eventosFiltrados = new ArrayList<>();

            for (Evento evento : eventos) {
                
                if(evento.getFechaEvento().isAfter(fechaInicio) && evento.getFechaEvento().isBefore(fechaFinal)){
                    
                    eventosFiltrados.add(evento);
                }
            }
            return eventosFiltrados;
        }
        return null;
    }

    @Override
    public List<Evento> obtenerEventosPorNombre(String titulo) {
        
        List<Evento> eventos = (List<Evento>) this.eventoRepository.findAll();

        if(!eventos.isEmpty()){
            List<Evento> eventosFiltrados = new ArrayList<>();

            for (Evento evento : eventos) {
                
                if(evento.getPelicula().getTitulo().equals(titulo)){
                    
                    eventosFiltrados.add(evento);
                }
            }
            return eventosFiltrados;
        }
        return null;

    }

    @Override
    public String eliminarEventoPorId(long codigoEvento) {

        if(this.eventoRepository.existsById(codigoEvento)){
            
            this.eventoRepository.deleteById(codigoEvento);
            return "El evento ha sido eliminado";
        }
        return "Ocurrió un error al eliminar el evento";
    }

    @Override
    public String eliminarEventosPorNombre(String titulo) {
        
        List<Evento> eventos = (List<Evento>) this.eventoRepository.findAll();

        if(!eventos.isEmpty()){
            for (Evento evento : eventos) {
                
                if(evento.getPelicula().getTitulo().equals(titulo)){
                    
                    this.eventoRepository.deleteById(evento.getCodigoEvento());
                }
            }
            return "Los eventos han sido eliminados";
        }
        return "Ocurrión un error al eliminar los eventos";
    }

    @Override
    public Evento editarEvento(long codigoEvento, Evento evento) {
        
        Optional<Evento> eventoOptional = this.eventoRepository.findById(codigoEvento);
        
        if(eventoOptional.isPresent()){

            Evento eventoActualizado = eventoOptional.get();
            
            eventoActualizado.setDisponible(evento.getDisponible());
            eventoActualizado.setFechaEvento(evento.getFechaEvento());
            eventoActualizado.setHoraInicio(evento.getHoraInicio());
            eventoActualizado.setIdioma(evento.getIdioma());
            eventoActualizado.setFormato(evento.getFormato());

            return this.eventoRepository.save(eventoActualizado);
        }
        return null;
    }
    
}
