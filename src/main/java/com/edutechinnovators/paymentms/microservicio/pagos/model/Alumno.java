package com.edutechinnovators.paymentms.microservicio.pagos.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Alumno {
    @Id
    @Column(unique = true,length = 9)
    private String rut;
    @Column(unique = true,length = 100)
    private String nombre;
    @Column(unique = true,length = 100)
    private String apellido;
    @Column(unique = true,length = 100)
    private String curso;

    @OneToMany(mappedBy = "alumno", cascade = CascadeType.ALL)
    @JsonManagedReference("alumno-boletas")
    private List<Boleta> boletas;


    }

