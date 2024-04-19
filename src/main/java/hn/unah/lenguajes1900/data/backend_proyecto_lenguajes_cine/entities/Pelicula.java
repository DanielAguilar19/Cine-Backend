package hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.entities;

import java.time.LocalTime;

import jakarta.persistence.CascadeType;
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
@Table(name = "peliculas")
@Data
public class Pelicula {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigopelicula")
    private long codigoPelicula;

    private String titulo;

    private LocalTime duracion;

    @JsonIgnore
    @OneToMany(mappedBy = "pelicula",cascade = CascadeType.ALL)
    private List<Evento> evento;


}
