package hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.entities;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

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

    @Column(name = "fechanacimiento")
    private LocalDate fechaNacimiento;

    private String telefono;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "codigousuario", referencedColumnName = "codigousuario")
    private Usuario usuario;

    @OneToMany(mappedBy = "cliente")
    private List<Compra> compras;
    
}
