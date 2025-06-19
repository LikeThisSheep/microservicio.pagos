package com.edutechinnovators.paymentms.microservicio.pagos.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

public class Emisor {

    @Id
    @Column(unique = true,length = 9)
    private Integer rut_escuela;
    @Column(unique = true,length = 100)
    private String nombre_escuela;
    @Column(unique = true,length = 100)
    private String direccion_escuela;
    @Column(unique = true,length = 100)
    private String comuna_escuela;

    @OneToMany(mappedBy = "emisor", cascade = CascadeType.ALL)
    private List<Boleta> boletas;

}
