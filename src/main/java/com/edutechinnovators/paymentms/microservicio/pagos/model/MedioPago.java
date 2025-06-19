package com.edutechinnovators.paymentms.microservicio.pagos.model;

import jakarta.persistence.Column;
import jakarta.persistence.Data;
import jakarta.persistence.NoArgsConstructor;
import jakarta.persistence.AllArgsConstructor;
import jakarta.persistence.Entity;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class MedioPago {
    @Column(unique = true,length = 100)
    private String tipo;
    @Column(unique = true,length = 100)
    private Integer monto_pagado;

}
