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

<<<<<<< HEAD
    @ManyToOne
    @JoinColumn(name = "codigoboleto", referencedColumnName = "codigoboleto")
    private List<Boleto> boletos;
=======
    @OneToMany(mappedBy = "detallefactura")
     private List<Boleto> boleto;
>>>>>>> c58952404f62cf53bf19f2dbc1e4a9cb06ad3500

     private Double subtotal;


}
