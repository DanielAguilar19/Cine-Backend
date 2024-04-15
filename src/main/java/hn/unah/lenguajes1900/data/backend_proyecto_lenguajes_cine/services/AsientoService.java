package hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.services;

import hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.entities.Asiento;

public interface AsientoService {
    
    public Asiento crearAsiento(Asiento asiento);

    public String eliminarAsiento(long codigoSala);

}
