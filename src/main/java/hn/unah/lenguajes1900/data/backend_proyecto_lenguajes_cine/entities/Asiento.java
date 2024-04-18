package hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.entities;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonManagedReference;

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

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "codigosala", referencedColumnName = "codigosala")
    private Sala sala;
    
    private int disponible;

    private String numeroAsiento;

    @OneToMany(mappedBy = "asiento")
    private List<Boleto> boletos;

}
