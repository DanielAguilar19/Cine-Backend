package hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.entities.Cliente;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Long>{
    @Query("SELECT c FROM Cliente c WHERE c.correo = :correo AND c.contrasenia = :contrasenia")
    String clientePorCorreoContrasenia(String correo, String contrasenia);
    
}
