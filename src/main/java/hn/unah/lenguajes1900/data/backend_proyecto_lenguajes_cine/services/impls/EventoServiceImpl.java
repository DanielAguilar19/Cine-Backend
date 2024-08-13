package hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.services.impls;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.entities.Evento;
import hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.entities.Pelicula;
import hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.entities.Sala;
import hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.repositories.EventoRepository;
import hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.repositories.PeliculaRepository;
import hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.repositories.SalaRepository;
import hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.services.EventoService;

@Service
public class EventoServiceImpl implements EventoService{

    @Autowired
    private EventoRepository eventoRepository;

    @Autowired
    private PeliculaRepository peliculaRepository;

    @Autowired
    private SalaRepository salaRepository;

    @Override
    public Evento crearEvento(Evento evento, long codigopelicula, long codigosala) {

        if(this.salaRepository.existsById(codigosala) && this.peliculaRepository.existsById(codigopelicula)){

            LocalDate fechaActual = LocalDate.now();

            if(evento.getFechaEvento().isBefore(fechaActual)){
                System.out.println("No puede agregar eventos con fechas anteriores.");
                return null;
            }

            Pelicula pelicula = this.peliculaRepository.findById(codigopelicula).get();
            Sala sala = this.salaRepository.findById(codigosala).get();

            List<Evento> eventosSala = sala.getEventos();
            eventosSala.add(evento);
            sala.setEventos(eventosSala);

            evento.setPelicula(pelicula);
            evento.setSala(sala);
            this.salaRepository.save(sala);

            List<Evento> eventos = (List<Evento>) this.eventoRepository.findAll();

            for (Evento eventodb : eventos) {
                
                if(eventodb.getFechaEvento().equals(evento.getFechaEvento()) &&
                eventodb.getHoraInicio().equals(evento.getHoraInicio()) &&
                eventodb.getSala().getCodigoSala() ==  evento.getSala().getCodigoSala()){
                    System.out.println("La sala se encuentra ocupada por otro evento en esta hora.");
                    return null;
                }
                
            }

            LocalDate fechaProximamente = fechaActual.plusMonths(1);

            if(evento.getFechaEvento().isAfter(fechaProximamente) || evento.getFechaEvento().isEqual(fechaProximamente)){
                evento.setDisponible(3);
            }
            
            if(evento.getFechaEvento().isAfter(fechaActual) && evento.getFechaEvento().isBefore(fechaProximamente)){
                evento.setDisponible(2);
            }

            if(evento.getFechaEvento().isEqual(fechaActual)){
                evento.setDisponible(1);
            }
            return this.eventoRepository.save(evento);

        }
        System.out.println("La sala o la película no existe en la base de datos.");
        return null; 
    }
    

@Override
public String eliminarEventoPorId(long codigoEvento) {
    if(this.eventoRepository.existsById(codigoEvento)){
            
        Optional<Evento> eventoOptional = this.eventoRepository.findById(codigoEvento);

        if(eventoOptional.isPresent()){

            Evento evento = eventoOptional.get();
            evento.setDisponible(0);
            this.eventoRepository.save(evento);
        }
        this.eventoRepository.deleteById(codigoEvento);
        return "El evento ha sido eliminado";
    }
    return "Ocurrió un error al eliminar el evento";
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

    @Override
    public String eliminarEventosPorNombre(String titulo) {
        List<Evento> eventos = (List<Evento>) this.eventoRepository.findAll();

        if(!eventos.isEmpty()){
            for (Evento evento : eventos) {
                
                if(evento.getPelicula().getTitulo().equals(titulo)){
                    
                    evento.setDisponible(0);
                    this.eventoRepository.save(evento);
                    this.eventoRepository.deleteById(evento.getCodigoEvento());
                }
            }
            return "Los eventos han sido eliminados";
        }
        return "Ocurrión un error al eliminar los eventos";
    }
    
    @Override
    public List<Evento> obtenerEventos() {
        return (List<Evento>) this.eventoRepository.findAll();
    }

    /* 
    @Override
    public List<Evento> obtenerEventosPorFecha(LocalDate fechaInicio, LocalDate fechaFinal) {
        List<Evento> eventos = (List<Evento>) this.eventoRepository.findAll();

        if(!eventos.isEmpty()){
            List<Evento> eventosFiltrados = new ArrayList<>();

            for (Evento evento : eventos) {
                if((evento.getFechaEvento().isAfter(fechaInicio) || evento.getFechaEvento().isEqual(fechaInicio))&& 
                (evento.getFechaEvento().isBefore(fechaFinal) || evento.getFechaEvento().isEqual(fechaFinal))){
                    
                    eventosFiltrados.add(evento);
                }
            }
            return eventosFiltrados;
        }
        return null;
    }
    */

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
}
