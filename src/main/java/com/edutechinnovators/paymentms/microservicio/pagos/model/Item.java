package com.edutechinnovators.paymentms.microservicio.pagos.model;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Data;
import jakarta.persistence.NoArgsConstructor;
import jakarta.persistence.AllArgsConstructor;
import jakarta.persistence.Entity;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Item {

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
