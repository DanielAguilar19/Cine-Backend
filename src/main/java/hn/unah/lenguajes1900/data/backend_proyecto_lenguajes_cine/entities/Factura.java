package hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.entities;

import java.time.LocalDate;



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
@Table(name = "facturas")
@Data
public class Factura {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigofactura")
    private Long codigoFactura; 

    @ManyToOne
    @JoinColumn(name = "codigocliente", referencedColumnName = "codigocliente")
    private Cliente cliente; 

    @Column(name = "numerotarjeta")
    private String numeroTarjeta; 

    @Column(name = "fechacompra")
    private LocalDate fechaCompra; 

    private Double descuento; 

    @Column(name = "totalcompra")
    private Double totalCompra; 

    @JsonIgnore
    @OneToMany(mappedBy = "factura")
    private List<DetalleFactura> detallefactura;




}
