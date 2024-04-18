package hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.services.impls;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.Validations.Validation;
import hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.entities.Asiento;
import hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.entities.Sala;
import hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.entities.TipoSala;
import hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.repositories.SalaRepository;
import hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.services.SalaService;

@Service
public class SalaServiceImpl implements SalaService{

    @Autowired
    private SalaRepository salaRepository;

    @Autowired
    private AsientoServiceImpl asientoServiceImpl;

    @Autowired
    private TipoSalaServiceImpl tipoSalaServiceImpl;

    @Override
    public Sala crearSala(Sala sala) {
        if(sala.getTipoSala().getTipoSala().matches("(vip|normal)")){

            TipoSala tipoSala = this.tipoSalaServiceImpl.obtenerTipoSalaPorNombre(sala.getTipoSala().getTipoSala());

            if(tipoSala != null){
                sala.setTipoSala(tipoSala);
                Sala saladb = this.salaRepository.save(sala);
                String[] filaArray = {"A","B","C","D","E","F","G","H","I"};

                if(saladb.getTipoSala().getTipoSala().equals("vip")){

                    for(int i=0; i< Validation.N_FILAS_SALA_VIP; i++){
                        String fila = filaArray[i];
                        for(int j=0; j< Validation.N_ASIENTOS_FILA; j++){
                            Asiento asiento = new Asiento();
                            asiento.setSala(saladb);
                            asiento.setDisponible(0);
                            asiento.setNumeroAsiento(String.format("%s", fila+(j+1)));
                            System.out.println(asiento.getNumeroAsiento());
                            this.asientoServiceImpl.crearAsiento(asiento);
                        }
                    }

                }else{
                    for(int i=0; i< Validation.N_FILAS_SALA_NORMAL; i++){
                        String fila = filaArray[i];
                        for(int j=0; j< Validation.N_ASIENTOS_FILA; j++){
                            Asiento asiento = new Asiento();
                            asiento.setSala(saladb);
                            asiento.setDisponible(0);
                            asiento.setNumeroAsiento(String.format("%s", fila+(j+1)));
                            this.asientoServiceImpl.crearAsiento(asiento);
                        }
                    }
                }
                System.out.println("Los asientos se crearon correctamente");
                return this.salaRepository.findById(saladb.getCodigoSala()).get();
            }
            System.out.println("El tipoSala no existe en la db");
            return null;
        }
        System.out.println("Nombre de tipoSala incorrecto.");
        return null;
    }

    @Override
    public String eliminarSalaPorId(long codigoSala) {

        if(this.salaRepository.existsById(codigoSala)){
            
            this.asientoServiceImpl.eliminarAsientos(codigoSala);
            this.salaRepository.deleteById(codigoSala);
            return "La sala se ha eliminado correctamente";
        }
        return "Ha ocurrido un error con la eliminación de la sala.";
    }
}
