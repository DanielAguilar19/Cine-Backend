package hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.services.impls;

import java.time.LocalDate;
import java.util.List;

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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'crearEvento'");
    }

    @Override
    public List<Evento> obtenerEventos() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'obtenerEventos'");
    }

    @Override
    public List<Evento> obtenerEventosPorFecha(LocalDate fechaInicio, LocalDate fechaFinal) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'obtenerEventosPorFecha'");
    }

    @Override
    public List<Evento> obtenerEventosPorNombre(String titulo) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'obtenerEventosPorNombre'");
    }

    @Override
    public String eliminarEventoPorId(long codigoEvento) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'eliminarEventoPorId'");
    }

    @Override
    public String eliminarEventosPorNombre(String titulo) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'eliminarEventosPorNombre'");
    }

    @Override
    public Evento editarEvento(long codigoEvento) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'editarEvento'");
    }
    
}
