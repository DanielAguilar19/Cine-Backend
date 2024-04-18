package hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "tiposala")
@Data
public class TipoSala {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigotiposala")
    private long codigoTipoSala;

    private String descripcion;
    
    private double precio;

    @JsonIgnore
    @OneToMany(mappedBy = "tipoSala")
    private List<Sala> salas;
}
