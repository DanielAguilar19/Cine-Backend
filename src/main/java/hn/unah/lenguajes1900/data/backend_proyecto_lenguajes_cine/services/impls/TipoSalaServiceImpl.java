package hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.services.impls;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.entities.TipoSala;
import hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.repositories.TipoSalaRepository;
import hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.services.TipoSalaService;

@Service
public class TipoSalaServiceImpl implements TipoSalaService{

    @Autowired
    private TipoSalaRepository tipoSalaRepository;

    @Override
    public TipoSala crearTipoSala(TipoSala tipoSala) {
        return this.tipoSalaRepository.save(tipoSala);
    }

    @Override
    public String editarTipoSala(long codigoTipoSala) {

        if(!this.tipoSalaRepository.existsById(codigoTipoSala)){
            this.tipoSalaRepository.findById(codigoTipoSala).get().setPrecio(
                this.tipoSalaRepository.findById(codigoTipoSala).get().getPrecio()
            );
            this.tipoSalaRepository.findById(codigoTipoSala).get().setTipoSala(
                this.tipoSalaRepository.findById(codigoTipoSala).get().getTipoSala()
            );
            return "Se han realizado los cambios.";
        }
        return "Ocurrió un problema: Posiblemente ha ingresado un tipo de sala que no existe...";
    }

    @Override
    public String eliminarTipoSalaPorNombre(String tipoSala) {
        
        List<TipoSala> tipoSalas = (List<TipoSala>) this.tipoSalaRepository.findAll();

        for (TipoSala tipoSala2 : tipoSalas) {
            if(tipoSala2.getTipoSala() == tipoSala){

                //Falta agregar la lógica para eliminar las salas relacionadas con el tipo de sala.

                long codigoTipoSala = tipoSala2.getCodigoTipoSala();
                this.tipoSalaRepository.deleteById(codigoTipoSala);
                return "El tipo de sala se ha eliminado correctamente.";
            }
        }
        return "Ha ocurrido un error al eliminar el tipo de sala.";
    }
    
}
