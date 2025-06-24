package com.edutechinnovators.paymentms.microservicio.pagos.repository;

import com.edutechinnovators.paymentms.microservicio.pagos.model.MedioPago;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MedioPagoRepository extends JpaRepository<MedioPago, Long> {
    Optional<MedioPago> findByBoleta_Folio(Integer folio);

    boolean existsByBoleta_Folio(Integer folio);
}
