package hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import lombok.Data;

@Entity
@Data
@Table(name = "asientoevento")
public class AsientoEvento {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codigoAsientoEvento;

    @Column(name = "disponible", nullable = false)
    private boolean disponible;

    @ManyToOne
    @JoinColumn(name = "codigoasiento", referencedColumnName = "codigoasiento")
    private Asiento asiento;

    @ManyToOne
    @JoinColumn(name = "codigoevento", referencedColumnName = "codigoevento")
    private Evento evento;

}