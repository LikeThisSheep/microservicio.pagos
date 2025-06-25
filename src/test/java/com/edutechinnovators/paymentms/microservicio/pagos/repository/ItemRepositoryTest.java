package com.edutechinnovators.paymentms.microservicio.pagos.repository;

import com.edutechinnovators.paymentms.microservicio.pagos.model.Alumno;
import com.edutechinnovators.paymentms.microservicio.pagos.model.Boleta;
import com.edutechinnovators.paymentms.microservicio.pagos.model.Emisor;
import com.edutechinnovators.paymentms.microservicio.pagos.model.Item;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
class ItemRepositoryTest {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private BoletaRepository boletaRepository;

    @Autowired
    private AlumnoRepository alumnoRepository;

    @Autowired
    private EmisorRepository emisorRepository;

    private Boleta boletaGuardada;

    @BeforeEach
    void setUp() {
        Alumno alumno = new Alumno();
        alumno.setRut("44444444-4");
        alumno.setNombre("Alumno");
        alumno.setApellido("DePrueba");
        alumno.setCurso("Curso Test");
        alumnoRepository.save(alumno);

        Emisor emisor = new Emisor();
        emisor.setRutEscuela("88888888-8");
        emisor.setNombreEscuela("Colegio Test");
        emisor.setDireccionEscuela("Av. de Prueba 123");
        emisorRepository.save(emisor);

        Boleta boleta = new Boleta();
        boleta.setAlumno(alumno);
        boleta.setEmisor(emisor);
        boleta.setFechaEmision(new Date());
        boletaGuardada = boletaRepository.save(boleta);
    }

    @Test
    @DisplayName("encontrar todos los items asociados a un folio de boleta")
    void buscarItemsPorFolioDeBoleta() {
        Item item1 = new Item();
        item1.setDescripcion("Cuaderno Universitario");
        item1.setCantidad(2);
        item1.setPrecioUnitario(1500);
        item1.setTotal(3000);
        item1.setBoleta(boletaGuardada);
        itemRepository.save(item1);

        Item item2 = new Item();
        item2.setDescripcion("Lápiz Grafito");
        item2.setCantidad(5);
        item2.setPrecioUnitario(300);
        item2.setTotal(1500);
        item2.setBoleta(boletaGuardada);
        itemRepository.save(item2);

        List<Item> itemsEncontrados = itemRepository.findAllByBoleta_Folio(boletaGuardada.getFolio());
        assertThat(itemsEncontrados).hasSize(2);
        assertThat(itemsEncontrados)
                .extracting(Item::getDescripcion)
                .containsExactlyInAnyOrder("Cuaderno Universitario", "Lápiz Grafito");
    }
}
