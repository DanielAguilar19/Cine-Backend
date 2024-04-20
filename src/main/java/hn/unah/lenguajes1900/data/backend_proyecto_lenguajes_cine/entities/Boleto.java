package hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.entities;


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
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "boletos")
@Data
public class Boleto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigoboleto")
    private long codigoBoleto;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "codigoevento", referencedColumnName = "codigoevento")
    private Evento evento;

    @JsonIgnore
    //@JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "codigoasiento", referencedColumnName = "codigoasiento")
    private Asiento asiento;


    @ManyToOne
    @JoinColumn(name = "codigodetallefactura", referencedColumnName = "codigodetallefactura")
    private DetalleFactura detallefactura;


}
