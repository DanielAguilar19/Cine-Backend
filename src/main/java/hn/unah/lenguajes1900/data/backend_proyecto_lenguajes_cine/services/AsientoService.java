package hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.services;

import java.util.List;

import hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.entities.Asiento;

public interface AsientoService {
    
    public Asiento crearAsiento(Asiento asiento);

    public String eliminarAsientos(long codigoSala);
    
    public List<Asiento> findAllByCodigoSala(long codigoSala);

}
