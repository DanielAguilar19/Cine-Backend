package hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.entities.Asiento;


@Repository
public interface AsientoRepository extends CrudRepository<Asiento, Long>{
    @Query("SELECT a, ae.disponible FROM Asiento a " +
    "JOIN a.sala s " +
    "JOIN s.tipoSala ts " +
    "JOIN AsientoEvento ae ON a.codigoAsiento = ae.asiento.codigoAsiento " +
    "JOIN Evento e ON ae.evento.codigoEvento = e.codigoEvento " +
    "WHERE e.codigoEvento = :codigoEvento")
    List<Asiento> findAllByCodigoEvento(@Param("codigoSala") long codigoSala);
    
}
