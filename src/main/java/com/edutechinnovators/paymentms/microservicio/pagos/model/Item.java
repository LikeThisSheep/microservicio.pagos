package com.edutechinnovators.paymentms.microservicio.pagos.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Item {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true,length = 100)
    private String descripcion;
    @Column(unique = true,length = 100)
    private Integer cantidad;
    @Column(unique = true,length = 100)
    private Integer precio_unitario;
    @Column(unique = true,length = 100)
    private Integer total;

    @ManyToOne
    @JoinColumn(name = "folio_boleta", referencedColumnName="folio")
    private Boleta boleta;
}
