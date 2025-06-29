package com.edutechinnovators.paymentms.microservicio.pagos.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "medio_pago")
public class MedioPago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true,length = 100)
    private String tipo;
    @Column(unique = true,length = 100)
    private Integer montoPagado;

    @OneToOne
    @JoinColumn(name = "folio_boleta", referencedColumnName = "folio")
    @JsonBackReference("boleta-mediopago")
    private Boleta boleta;
}
