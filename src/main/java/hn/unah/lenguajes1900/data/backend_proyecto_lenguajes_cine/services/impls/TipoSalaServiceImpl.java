package hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.services.impls;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.entities.Sala;
import hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.entities.TipoSala;
import hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.repositories.SalaRepository;
import hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.repositories.TipoSalaRepository;
import hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.services.TipoSalaService;

@Service
public class TipoSalaServiceImpl implements TipoSalaService{

    @Autowired
    private TipoSalaRepository tipoSalaRepository;

    @Autowired
    private SalaRepository salaRepository;

    @Autowired
    private AsientoServiceImpl asientoServiceImpl;

    @Override
    public TipoSala crearTipoSala(TipoSala tipoSala) {

        if(tipoSala.getTipoSala().matches("(vip|normal)")){
            TipoSala tsnormal = obtenerTipoSalaPorNombre("normal");
            TipoSala tsvip = obtenerTipoSalaPorNombre("vip");

            if(tsnormal == null && tipoSala.getTipoSala().equals("normal")){
                System.out.println(tipoSala.getTipoSala());
                return this.tipoSalaRepository.save(tipoSala);
            }
            if(tsvip == null && tipoSala.getTipoSala().equals("vip")){
                System.out.println(tipoSala.getTipoSala());
                return this.tipoSalaRepository.save(tipoSala);
            }
        }
        //System.out.println("no se envia el nombre que es");
        return null;
    }

    @Override
    public String editarTipoSala(TipoSala tipoSala) {

        Optional<TipoSala> tipoSalaOptional = this.tipoSalaRepository.findById(tipoSala.getCodigoTipoSala());

        if(tipoSalaOptional.isPresent() && tipoSala.getTipoSala().equals(tipoSalaOptional.get().getTipoSala())){
            TipoSala tsdb = tipoSalaOptional.get();
            tsdb.setPrecio(tipoSala.getPrecio());
            //El tipo de sala no puede cambiar de tipo.
            //tsdb.setTipoSala(tipoSala.getTipoSala());
            this.tipoSalaRepository.save(tsdb);

            return "Se han realizado los cambios.";
        }
        return "Ocurrió un problema...";
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

    public String eliminarTipoSalaPorNombre(String nombreTipoSala) {
        
        List<TipoSala> tipoSalas = (List<TipoSala>) this.tipoSalaRepository.findAll();

        if(!tipoSalas.isEmpty()){
            for (TipoSala tipoSala : tipoSalas) {
                if(tipoSala.getTipoSala().equals(nombreTipoSala)){

                    //this.salaServiceImpl.eliminarSalasPorIdTipoSala(tipoSala.getCodigoTipoSala());
                    long codigoTipoSala = tipoSala.getCodigoTipoSala();
                    List<Sala> salas = (List<Sala>) this.salaRepository.findAll();

                    if(!salas.isEmpty()){
                        for (Sala sala : salas) {
                            if(sala.getTipoSala().getCodigoTipoSala() == codigoTipoSala){

                                long codigoSala = sala.getCodigoSala();
                                this.asientoServiceImpl.eliminarAsientos(codigoSala);
                                this.salaRepository.deleteById(codigoSala);
                            }
                        }
                    }
                this.tipoSalaRepository.deleteById(tipoSala.getCodigoTipoSala());
                }
            }
        return "El tipo de sala se ha eliminado correctamente";
        }
    return "Ha ocurrido un error al eliminar el tipo de sala.";
    }

}
