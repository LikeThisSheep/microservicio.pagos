package com.edutechinnovators.paymentms.microservicio.pagos.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class MedioPago {
    @Column(unique = true,length = 100)
    private String tipo;
    @Column(unique = true,length = 100)
    private Integer monto_pagado;

    @OneToOne
    @JoinColumn(name = "folio_boleta", referencedColumnName = "folio")
    private Boleta boleta;


}
