package hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.entities;

import java.time.LocalDate;
import java.util.List;

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
@Table(name = "compras")
@Data
public class Compra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigocompra")
    private long codigoCompra;

    @ManyToOne
    @JoinColumn(name = "codigocliente", referencedColumnName = "codigocliente")
    private Cliente cliente;

    @Column(name = "numerotarjeta")
    private String numeroTarjeta;

    @Column(name = "cantidadboletos")
    private int cantidadBoletos;

    @Column(name = "fechacompra")
    private LocalDate fechaCompra;

    private double descuento;

    @Column(name = "totalcompra")
    private double totalCompra;

    @OneToMany(mappedBy = "compra", cascade = CascadeType.ALL)
    private List<Boleto> boletos;
    
}
