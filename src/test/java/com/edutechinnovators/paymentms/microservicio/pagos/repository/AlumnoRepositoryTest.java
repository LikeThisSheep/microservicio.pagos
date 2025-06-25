package com.edutechinnovators.paymentms.microservicio.pagos.repository;

import com.edutechinnovators.paymentms.microservicio.pagos.model.Alumno;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
class AlumnoRepositoryTest {

    @Autowired
    private AlumnoRepository alumnoRepository;

    @Test
    @DisplayName("Debe guardar un alumno y recuperarlo correctamente por su RUT")
    void guardarYRecuperarAlumno() {
        Alumno alumno = new Alumno();
        alumno.setRut("11111111-1");
        alumno.setNombre("Juan");
        alumno.setApellido("Perez");
        alumno.setCurso("Quinto Básico");

        alumnoRepository.save(alumno);
        Optional<Alumno> alumnoRecuperado = alumnoRepository.findByRut("11111111-1");
        assertThat(alumnoRecuperado).isPresent();
        assertThat(alumnoRecuperado.get().getNombre()).isEqualTo("Juan");
        assertThat(alumnoRecuperado.get().getCurso()).isEqualTo("Quinto Básico");
    }

}
