package hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "asientos")
@Data
public class Asiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigoasiento")
    private long codigoAsiento;

    @ManyToOne
    @JoinColumn(name = "codigosala", referencedColumnName = "codigosala")
    private Sala sala;
    
    private boolean disponible;

    private int fila;

    private int columna;

    @OneToMany(mappedBy = "asiento")
    private List<Boleto> boletos;

}
