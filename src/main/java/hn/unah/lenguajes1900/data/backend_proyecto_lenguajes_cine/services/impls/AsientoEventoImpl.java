package hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.services.impls;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.entities.AsientoEvento;
import hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.repositories.AsientoEventoRepository;
import hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.services.AsientoEventoService;

@Service
public class AsientoEventoImpl implements AsientoEventoService{

    @Autowired
    private AsientoEventoRepository AsiEveRepo;

    @Override
    public List<AsientoEvento> asientosLibresPorEvento(long codigoAsientoEvento) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'asientosOcupadosPorEvento'");
        /* SELECT codigoasiento from asientoevento WHERE disponible = TRUE and codigoevento = 1; */
    }

    @Override
    public List<AsientoEvento> asientosOcupadosPorEvento(long codigoAsientoEvento) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'asientosOcupadosPorEvento'");
        /* SELECT codigoasiento from asientoevento WHERE disponible = TRUE and codigoevento = 1; */
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

    
}