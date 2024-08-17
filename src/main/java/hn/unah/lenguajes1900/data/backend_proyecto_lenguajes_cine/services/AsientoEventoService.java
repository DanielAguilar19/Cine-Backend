package hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.services;

import java.util.List;

import org.springframework.stereotype.Service;

import hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.entities.Asiento;

@Service
public interface AsientoEventoService{

    List<Asiento> obtenerAsientosLibresPorEvento(long codigoEvento);

    List<Asiento> obtenerAsientosOcupadosPorEvento(long codigoEvento);
    
    public String cambiarDisponibilidadAiento(boolean disponible, long codigoAsientoEvento);
    

}
