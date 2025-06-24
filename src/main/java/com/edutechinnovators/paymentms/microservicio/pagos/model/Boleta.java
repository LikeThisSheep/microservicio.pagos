package com.edutechinnovators.paymentms.microservicio.pagos.model;

import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Boleta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Integer folio;

    private Date fechaEmision;

    @ManyToOne
    @JoinColumn(name = "rut_alumno", referencedColumnName = "rut")
    @JsonBackReference("alumno-boletas")
    private Alumno alumno;

    @ManyToOne
    @JoinColumn(name = "rut_emisor", referencedColumnName = "rut_escuela")
    @JsonBackReference("emisor-boletas")
    private Emisor emisor;

    @OneToMany(mappedBy = "boleta", cascade = CascadeType.ALL)
    @JsonManagedReference("boleta-items")
    private List<Item> items;

    @OneToOne(mappedBy = "boleta", cascade = CascadeType.ALL)
    @JsonManagedReference("boleta-totales")
    private Totales totales;

    @OneToOne(mappedBy = "boleta", cascade = CascadeType.ALL)
    @JsonManagedReference("boleta-mediopago")
    private MedioPago mediopago;
}


