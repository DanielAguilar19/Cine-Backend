package hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "usuarios")
@Data
public class Usuario {
    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigousuario")
    private int codigoUsuario; 
     
    private String correo;
   
    private String contrasenia;
   
    private String rol; 

    @OneToOne(mappedBy = "usuario")
    private Cliente cliente;

}
