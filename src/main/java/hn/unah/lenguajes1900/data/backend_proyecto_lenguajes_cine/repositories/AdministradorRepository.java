package hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.entities.Administrador;

public interface AdministradorRepository extends JpaRepository <Administrador, Long> {
    
}
