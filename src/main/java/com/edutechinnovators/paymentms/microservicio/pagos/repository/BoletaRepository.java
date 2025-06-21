package com.edutechinnovators.paymentms.microservicio.pagos.repository;

import com.edutechinnovators.paymentms.microservicio.pagos.model.Boleta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoletaRepository extends JpaRepository<Boleta, Integer> {
    Boleta findByFolio(Integer folio);

    boolean existsByFolio(Integer folio);

    void deleteByFolio(Integer folio);
}
