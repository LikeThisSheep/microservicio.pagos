package com.edutechinnovators.paymentms.microservicio.pagos.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonBackReference;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Totales {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true,length = 100)
    private Integer precioNeto;
    @Column(unique = true,length = 100)
    private Integer iva;
    @Column(unique = true,length = 100)
    private Integer total;

    @OneToOne
    @JoinColumn(name = "folio_boleta", referencedColumnName = "folio")
    @JsonBackReference("boleta-totales")
    private Boleta boleta;
}
