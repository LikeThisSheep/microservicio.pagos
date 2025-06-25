package com.edutechinnovators.paymentms.microservicio.pagos.repository;

import com.edutechinnovators.paymentms.microservicio.pagos.model.Alumno;
import com.edutechinnovators.paymentms.microservicio.pagos.model.Boleta;
import com.edutechinnovators.paymentms.microservicio.pagos.model.Emisor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
class BoletaRepositoryTest {

    @Autowired
    private BoletaRepository boletaRepository;

    @Autowired
    private AlumnoRepository alumnoRepository;

    @Autowired
    private EmisorRepository emisorRepository;

    @Test
    @DisplayName("Guardar y recuperar una boleta con su alumno y emisor asociados")
    void guardarBoletaConRelaciones() {
        Alumno alumno = new Alumno();
        alumno.setRut("12345678-9");
        alumno.setNombre("Carlos");
        alumno.setApellido("López");
        alumno.setCurso("Primero Medio");
        alumnoRepository.save(alumno);

        Emisor emisor = new Emisor();
        emisor.setRutEscuela("98765432-1");
        emisor.setNombreEscuela("Colegio de Pruebas");
        emisor.setDireccionEscuela("Av. Ficticia 123");
        emisorRepository.save(emisor);

        Boleta boleta = new Boleta();
        boleta.setAlumno(alumno);
        boleta.setEmisor(emisor);
        boleta.setFechaEmision(new Date());

        Boleta boletaGuardada = boletaRepository.save(boleta);
        Optional<Boleta> boletaRecuperada = boletaRepository.findById(boletaGuardada.getFolio());

        assertThat(boletaRecuperada).isPresent();
        assertThat(boletaRecuperada.get().getAlumno()).isNotNull();
        assertThat(boletaRecuperada.get().getEmisor()).isNotNull();
        assertThat(boletaRecuperada.get().getAlumno().getRut()).isEqualTo("12345678-9");
        assertThat(boletaRecuperada.get().getEmisor().getRutEscuela()).isEqualTo("98765432-1");
    }
}