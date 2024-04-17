package hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
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
@Table(name = "salas")
@Data
public class Sala {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigosala")
    private long codigoSala;

    @ManyToOne
    @JoinColumn(name = "codigotiposala", referencedColumnName = "codigotiposala")
    private TipoSala tipoSala;

    @JsonBackReference
    @OneToMany(mappedBy = "sala", cascade = CascadeType.ALL)
    private List<Asiento> asientos;

    @OneToMany(mappedBy = "sala")
    private List<Evento> eventos;
    
}