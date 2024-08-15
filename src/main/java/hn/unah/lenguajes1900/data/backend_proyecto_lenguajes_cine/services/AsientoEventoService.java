package hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.services;

import java.util.List;

import org.springframework.stereotype.Service;
import hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.entities.AsientoEvento;

@Service
public interface AsientoEventoService{

    public List<AsientoEvento> asientosLibresPorEvento(long codigoEvento);

    public List<AsientoEvento> asientosOcupadosPorEvento(long codigoEvento);
    
    public String cambiarDisponibilidadAiento(boolean disponible, long codigoAsientoEvento);
    

}
