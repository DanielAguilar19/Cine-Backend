package hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.entities.Asiento;


@Repository
public interface AsientoRepository extends CrudRepository<Asiento, Long>{

      
    @Query("SELECT a FROM Asiento a WHERE a.sala.codigoSala = :codigoSala")
    List<Asiento> findAllByCodigoSala(long codigoSala);

    
}
