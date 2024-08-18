package hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.repositories;

import org.springframework.stereotype.Repository;

import hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.entities.Asiento;
import hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.entities.AsientoEvento;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


@Repository
public interface AsientoEventoRepository extends CrudRepository<AsientoEvento, Long>{ 
    
    @Query("SELECT ae.asiento FROM AsientoEvento ae WHERE ae.evento.codigoEvento = :codigoEvento AND ae.disponible = true")
    List<Asiento> findAvailableAsientosByEvento(long codigoEvento);

    @Query("SELECT ae.asiento FROM AsientoEvento ae WHERE ae.evento.codigoEvento = :codigoEvento AND ae.disponible = false")
    List<Asiento> findOccupiedAsientosByEvento(long codigoEvento);

    @Query("SELECT ae.disponible FROM AsientoEvento ae WHERE ae.asiento.codigoAsiento = :codigoAsiento")
    Boolean findDisponibilidadByCodigoAsiento(@Param("codigoAsiento") Long codigoAsiento);}
