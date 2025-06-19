package com.edutechinnovators.paymentms.microservicio.pagos.model;

import jakarta.persistence.Column;

public class Totales {
    @Column(unique = true,length = 100)
    private Integer precio_neto;
    @Column(unique = true,length = 100)
    private Integer iva;
    @Column(unique = true,length = 100)
    private Integer total;


}
