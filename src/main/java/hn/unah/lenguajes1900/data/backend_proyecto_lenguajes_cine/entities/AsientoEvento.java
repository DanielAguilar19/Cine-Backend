package hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.entities;

import jakarta.persistence.Entity;
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
    @Column(name = "codigoasiento")
    private long codigoAsiento;

    @Id
    @Column(name = "codigoevento")
    private long codigoEvento;

    @Column(name = "disponible", nullable = false)
    private boolean disponible;

    @ManyToOne
    @JoinColumn(name = "codigoasiento", referencedColumnName = "codigoasiento")
    private Asiento asiento;

    @ManyToOne
    @JoinColumn(name = "codigoevento", referencedColumnName = "codigoevento")
    private Evento evento;

}