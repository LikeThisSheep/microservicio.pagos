package com.edutechinnovators.paymentms.microservicio.pagos.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Totales {
    @Id
    private Integer id;

    @Column(unique = true,length = 100)
    private Integer precio_neto;
    @Column(unique = true,length = 100)
    private Integer iva;
    @Column(unique = true,length = 100)
    private Integer total;

    @OneToOne
    @JoinColumn(name = "folio_boleta", referencedColumnName = "folio")
    private Boleta boleta;



}
