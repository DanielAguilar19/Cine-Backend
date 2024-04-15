package hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.services;

import java.time.LocalDate;
import java.util.List;

import hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.entities.Evento;

public interface EventoService {

    public Evento crearEvento(Evento evento);

    public List<Evento> obtenerEventos();
    
    public List<Evento> obtenerEventosPorFecha(LocalDate fechaInicio, LocalDate fechaFinal);

    public List<Evento> obtenerEventosPorNombre(String titulo);

    public String eliminarEventoPorId(long codigoEvento);

    public String eliminarEventosPorNombre(String titulo);

    public Evento editarEvento(long codigoEvento);
    
}
