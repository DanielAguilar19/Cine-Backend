package hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.services.impls;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.entities.Asiento;
import hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.entities.AsientoEvento;
import hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.repositories.AsientoEventoRepository;
import hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.services.AsientoEventoService;

@Service
public class AsientoEventoImpl implements AsientoEventoService{

    @Autowired
    private AsientoEventoRepository AsiEveRepo;

    @Override
    public List<Asiento> obtenerAsientosLibresPorEvento(long codigoEvento) {
        return AsiEveRepo.findAvailableAsientosByEvento(codigoEvento);
    }

    @Override
    public List<Asiento> obtenerAsientosOcupadosPorEvento(long codigoEvento) {
        return AsiEveRepo.findOccupiedAsientosByEvento(codigoEvento);
    }

    @Override
    public String cambiarDisponibilidadAiento(boolean disponible, long codigoAsientoEvento) {
        if (AsiEveRepo.existsById(codigoAsientoEvento)) {
            AsientoEvento asientoEventoActual = AsiEveRepo.findById(codigoAsientoEvento).orElse(null);
            asientoEventoActual.setDisponible(disponible);
            return "Cambiado con exito";
        }
            return "Error";
    }

    @Override
    public boolean obtenerDisponibilidad(Long codigoAsiento) {
        return this.AsiEveRepo.findDisponibilidadByCodigoAsiento(codigoAsiento); 
        
    }

    
}