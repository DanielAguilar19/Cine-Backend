package hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.services;

import hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.entities.TipoSala;

public interface TipoSalaService {
    
    public TipoSala crearTipoSala(TipoSala tipoSala);

    public String editarTipoSala(long codigoTipoSala);

    public String eliminarTipoSalaPorNombre(String tipoSala);
    
}
