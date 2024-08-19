package hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "clientes")
@Data
public class Cliente {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "codigocliente")
    private long codigoCliente;

    @Column(name = "nombrecompleto")
    private String nombreCompleto;

    @Column(name = "clientefrecuente")
    private int clienteFrecuente;

    private String telefono;

    private String correo; 

    private String contrasenia; 

    @JsonIgnore
    @OneToMany(mappedBy = "cliente")
    private List<Factura> factura;
    
}
