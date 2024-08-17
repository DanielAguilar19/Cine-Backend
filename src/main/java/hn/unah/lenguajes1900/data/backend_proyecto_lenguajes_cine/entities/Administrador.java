package hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "administradores")
@Data
public class Administrador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigoadmin")
    private long codigoAdmin;

    @Column(name = "nombrecompleto")
    private String nombreCompleto;

    @Column(name = "fechanacimiento")
    private LocalDate fechaNacimiento;

    private String telefono;

    private String correo; 

    private String contrasenia;
    
}
