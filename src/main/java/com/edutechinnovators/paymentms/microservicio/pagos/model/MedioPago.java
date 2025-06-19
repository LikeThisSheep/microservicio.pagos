package com.edutechinnovators.paymentms.microservicio.pagos.model;

import jakarta.persistence.Column;

public class MedioPago {
    @Column(unique = true,length = 100)
    private String tipo;
    @Column(unique = true,length = 100)
    private Integer monto_pagado;

}
