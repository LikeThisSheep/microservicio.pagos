package com.edutechinnovators.paymentms.microservicio.pagos.repository;

import com.edutechinnovators.paymentms.microservicio.pagos.model.Emisor;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmisorRepository extends JpaRepository<Emisor, String> {
    Optional<Emisor> findByRutEscuela(String rutEscuela);
    boolean existsByRutEscuela(String rutEscuela);
}
