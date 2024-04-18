package hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.services.impls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.configurations.Configuration;
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
        if(sala.getTipoSala().getDescripcion().matches("(vip|normal)")){

            TipoSala tipoSala = this.tipoSalaServiceImpl.obtenerTipoSalaPorNombre(sala.getTipoSala().getDescripcion());

            if(tipoSala != null){
                sala.setTipoSala(tipoSala);
                Sala saladb = this.salaRepository.save(sala);

                if(saladb.getTipoSala().getDescripcion().equals("vip")){
                    for(int i=1; i<= Configuration.N_FILAS_SALA_VIP; i++){
                        for(int j=1; j<= Configuration.N_ASIENTOS_FILA; j++){
                            Asiento asiento = new Asiento();
                            asiento.setSala(saladb);
                            asiento.setDisponible(0);
                            /*asiento.setFila(i);
                            asiento.setColumna(j);*/
                            this.asientoServiceImpl.crearAsiento(asiento);
                        }
                    }

                }else{
                    for(int i=1; i<= Configuration.N_FILAS_SALA_NORMAL; i++){
                        for(int j=1; j<= Configuration.N_ASIENTOS_FILA; j++){
                            Asiento asiento = new Asiento();
                            asiento.setSala(saladb);
                            asiento.setDisponible(0);
                           /*  asiento.setFila(i);
                            asiento.setColumna(j);*/
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
