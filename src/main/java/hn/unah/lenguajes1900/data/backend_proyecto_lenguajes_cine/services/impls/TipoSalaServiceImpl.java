package hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.services.impls;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.entities.TipoSala;
import hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.repositories.TipoSalaRepository;
import hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.services.TipoSalaService;

//Todos estos metodos funcionan correctamente
@Service
public class TipoSalaServiceImpl implements TipoSalaService{

    @Autowired
    private TipoSalaRepository tipoSalaRepository;

    @Override
    public TipoSala crearTipoSala(TipoSala tipoSala) {

        if(tipoSala.getTipoSala().matches("(vip|normal)")){
            return this.tipoSalaRepository.save(tipoSala);
        }
        return null;
    }

    @Override
    public String editarTipoSala(TipoSala tipoSala) {

        Optional<TipoSala> tipoSalaOptional = this.tipoSalaRepository.findById(tipoSala.getCodigoTipoSala());

        if(tipoSalaOptional.isPresent()){
            TipoSala tsdb = tipoSalaOptional.get();
            tsdb.setPrecio(tipoSala.getPrecio());
            tsdb.setTipoSala(tipoSala.getTipoSala());
            this.tipoSalaRepository.save(tsdb);

            return "Se han realizado los cambios.";
        }
        return "Ocurrió un problema: Posiblemente ha ingresado un tipo de sala que no existe...";
    }

    @Override
    public TipoSala obtenerTipoSalaPorNombre(String nombreTipoSala){

        List<TipoSala> tipoSalas = (List<TipoSala>) this.tipoSalaRepository.findAll();

        for (TipoSala tipoSala2 : tipoSalas) {
            if(tipoSala2.getTipoSala().equals(nombreTipoSala)){

                return tipoSala2;                
            }
        }
        return null;
    }

    @Override
    public String eliminarTipoSalaPorNombre(String nombreTipoSala) {
        
        List<TipoSala> tipoSalas = (List<TipoSala>) this.tipoSalaRepository.findAll();

        for (TipoSala tipoSala2 : tipoSalas) {
            if(tipoSala2.getTipoSala().equals(nombreTipoSala)){

                this.tipoSalaRepository.deleteById(tipoSala2.getCodigoTipoSala());

                //Optional<TipoSala> tipoSala = this.tipoSalaRepository.findById(tipoSala2.getCodigoTipoSala());
                //Falta agregar la lógica para eliminar las salas relacionadas con el tipo de sala.

                //this.tipoSalaRepository.deleteById(tipoSala.get().getCodigoTipoSala());
                return "El tipo de sala se ha eliminado correctamente.";
            }
        }
        return "Ha ocurrido un error al eliminar el tipo de sala.";
    }

}
