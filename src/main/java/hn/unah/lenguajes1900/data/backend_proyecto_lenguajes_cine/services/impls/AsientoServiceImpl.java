package hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.services.impls;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.entities.Asiento;
import hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.repositories.AsientoRepository;
import hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.repositories.SalaRepository;
import hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.services.AsientoService;

@Service
public class AsientoServiceImpl implements AsientoService{

    @Autowired
    private SalaRepository salaRepository;

    @Autowired
    private AsientoRepository asientoRepository;

    @Override
    public Asiento crearAsiento(Asiento asiento) {
        return this.asientoRepository.save(asiento);
    }

    @Override
    public List<Asiento> findAllByCodigoSala(long codigoSala) {

        if(this.salaRepository.existsById(codigoSala)){

            return this.asientoRepository.findAllByCodigoEvento(codigoSala);
        }
        return null;
    }


    @Override
    public String eliminarAsientos(long codigoSala) {

        if(this.salaRepository.existsById(codigoSala)){
            List<Asiento> asientos = (List<Asiento>) this.asientoRepository.findAll();

            for (Asiento asiento : asientos) {
                if(asiento.getSala().getCodigoSala() == codigoSala){

                    this.asientoRepository.delete(asiento);
                }
            }
            return "Asientos eliminados.";
        }
        return "Ha ocurrido un problema con la eliminación de los asientos.";
    }
}
