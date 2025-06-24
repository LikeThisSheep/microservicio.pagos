package com.edutechinnovators.paymentms.microservicio.pagos.repository;

import com.edutechinnovators.paymentms.microservicio.pagos.model.Totales;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TotalesRepository extends JpaRepository<Totales, Long> {
    Optional<Totales> findByBoleta_Folio(Integer folio);

    boolean existsByBoleta_Folio(Integer folio);
}
