package com.edutechinnovators.paymentms.microservicio.pagos.model;

import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Boleta {

    @Id
    @Column(unique = true, length = 100)
    private Integer folio;

    private Date fecha_emision;

    @ManyToOne
    @JoinColumn(name = "rut_alumno", referencedColumnName = "rut")
    private Alumno alumno;

    @ManyToOne
    @JoinColumn(name = "rut_emisor", referencedColumnName = "rut_escuela")
    private Emisor emisor;

    @OneToMany(mappedBy = "boleta", cascade = CascadeType.ALL)
    private List<Item> items;

    @OneToOne(mappedBy = "boleta", cascade = CascadeType.ALL)
    private Totales totales;

    @OneToOne(mappedBy = "boleta", cascade = CascadeType.ALL)
    private MedioPago mediopago;
}


