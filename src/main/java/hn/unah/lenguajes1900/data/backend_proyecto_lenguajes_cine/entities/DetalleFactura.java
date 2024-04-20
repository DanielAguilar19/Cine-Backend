package hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "detallefactura")
@Data
public class DetalleFactura {
    


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigodetallefactura")
    private Long codigoDetalleFactura; 

    @Column(name = "cantidadboletos")
    private int cantidadBoletos;
    
    @ManyToOne
    @JoinColumn(name = "codigofactura", referencedColumnName = "codigofactura")
    private Factura factura; 

    @ManyToOne
    @JoinColumn(name = "codigoboleto", referencedColumnName = "codigoboleto")
    private List<Boleto> boletos;

    private Double subtotal;


}
