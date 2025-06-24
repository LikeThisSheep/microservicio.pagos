package com.edutechinnovators.paymentms.microservicio.pagos.repository;

import com.edutechinnovators.paymentms.microservicio.pagos.model.Alumno;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AlumnoRepository extends JpaRepository<Alumno, String> {
    Optional<Alumno> findByRut(String rut);

    boolean existsByRut(String rut);

    List<Alumno> findAllByCurso(String curso);
}
