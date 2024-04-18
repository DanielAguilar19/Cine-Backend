package hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.entities;


import java.time.LocalDate;
import java.time.LocalTime;
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
@Table(name = "eventos")
@Data
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigoevento")
    private long codigoEvento;

    @ManyToOne
    @JoinColumn(name = "codigopelicula", referencedColumnName = "codigopelicula")
    private Pelicula pelicula;

    @ManyToOne
    @JoinColumn(name = "codigosala", referencedColumnName = "codigosala")
    private Sala sala;

    private int disponible;

    @Column(name = "horainicio")
    private LocalTime horaInicio;

    @Column(name = "fechaevento")
    private LocalDate fechaEvento;

    private String idioma;

    private String formato;

    @OneToMany(mappedBy = "evento")
    private List<Boleto> boletos;
    
}
