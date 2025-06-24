package com.edutechinnovators.paymentms.microservicio.pagos.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.Entity;
import com.fasterxml.jackson.annotation.JsonManagedReference;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Emisor {

    @Id
    @Column(name = "rut_escuela", unique = true, length = 12)
    private String rutEscuela;
    @Column(unique = true,length = 100)
    private String nombreEscuela;
    @Column(unique = true,length = 100)
    private String direccionEscuela;

    @OneToMany(mappedBy = "emisor", cascade = CascadeType.ALL)
    @JsonManagedReference("emisor-boletas")
    private List<Boleta> boletas;
}
