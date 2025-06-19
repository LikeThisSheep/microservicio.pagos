package com.edutechinnovators.paymentms.microservicio.pagos.model;
import java.util.List;
import java.util.Date;


import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class Boleta {
    @Id
    @Column(unique = true,length = 100)
    private Integer folio;
    @Column(unique = true,length = 100)
    private Date fecha_emision;
    @Column(unique = true,length = 100)
    private Alumno alumno;
    @Column(unique = true,length = 100)
    private Emisor emisor;
    @Column(unique = true,length = 100)
    private List<String> Items;
    @Column(unique = true,length = 100)
    private Totales totales;
    @Column(unique = true,length = 100)
    private MedioPago mediopago;

    @ManyToOne
    @JoinColumn(name = "rut_alumno", referencedColumnName="rut")
    private Alumno alumno2;
    @ManyToOne
    @JoinColumn(name = "rut_emisor", referencedColumnName="rut_escuela")
    private Emisor emisor2;


}
