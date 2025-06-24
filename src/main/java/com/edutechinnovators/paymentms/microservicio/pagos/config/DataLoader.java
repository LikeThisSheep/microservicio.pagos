package com.edutechinnovators.paymentms.microservicio.pagos.config;

import com.edutechinnovators.paymentms.microservicio.pagos.model.Alumno;
import com.edutechinnovators.paymentms.microservicio.pagos.model.Boleta;
import com.edutechinnovators.paymentms.microservicio.pagos.model.Emisor;
import com.edutechinnovators.paymentms.microservicio.pagos.model.Item;
import com.edutechinnovators.paymentms.microservicio.pagos.model.MedioPago;
import com.edutechinnovators.paymentms.microservicio.pagos.model.Totales;
import com.edutechinnovators.paymentms.microservicio.pagos.repository.AlumnoRepository;
import com.edutechinnovators.paymentms.microservicio.pagos.repository.BoletaRepository;
import com.edutechinnovators.paymentms.microservicio.pagos.repository.EmisorRepository;
import com.edutechinnovators.paymentms.microservicio.pagos.repository.ItemRepository;
import com.edutechinnovators.paymentms.microservicio.pagos.repository.MedioPagoRepository;
import com.edutechinnovators.paymentms.microservicio.pagos.repository.TotalesRepository;

import net.datafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Component
public class DataLoader implements CommandLineRunner {

    private final AlumnoRepository alumnoRepository;
    private final BoletaRepository boletaRepository;
    private final EmisorRepository emisorRepository;
    private final ItemRepository itemRepository;
    private final MedioPagoRepository medioPagoRepository;
    private final TotalesRepository totalesRepository;

    public DataLoader(
            AlumnoRepository alumnoRepository,
            BoletaRepository boletaRepository,
            EmisorRepository emisorRepository,
            ItemRepository itemRepository,
            MedioPagoRepository medioPagoRepository,
            TotalesRepository totalesRepository
    ) {
        this.alumnoRepository = alumnoRepository;
        this.boletaRepository = boletaRepository;
        this.emisorRepository = emisorRepository;
        this.itemRepository = itemRepository;
        this.medioPagoRepository = medioPagoRepository;
        this.totalesRepository = totalesRepository;
    }

    @Override
    public void run(String... args) {
        Faker faker = new Faker(new Locale("es-CL"));

        for (int i = 0; i < 10; i++) {
            Alumno alumno = new Alumno();
            alumno.setRut(faker.idNumber().valid());
            alumno.setNombre(faker.name().firstName());
            alumno.setApellido(faker.name().lastName());
            alumno.setCurso(faker.educator().course());
            alumnoRepository.save(alumno);

            Emisor emisor = new Emisor();
            emisor.setRutEscuela(faker.idNumber().valid()); 
            emisor.setNombreEscuela(faker.university().name());
            emisor.setDireccionEscuela(faker.address().fullAddress());
            emisorRepository.save(emisor);

            Boleta boleta = new Boleta();
            boleta.setFechaEmision(new Date());
            boleta.setAlumno(alumno);
            boleta.setEmisor(emisor);

            List<Item> items = new ArrayList<>();
            int precioNeto = 0;

            for (int j = 0; j < faker.number().numberBetween(1, 4); j++) {
                Item item = new Item();
                int cantidad = faker.number().numberBetween(1, 3);
                int precioUnitario = faker.number().numberBetween(2000, 10000);
                
                item.setDescripcion(faker.commerce().productName());
                item.setCantidad(cantidad);
                item.setPrecioUnitario(precioUnitario);
                item.setTotal(cantidad * precioUnitario);
                item.setBoleta(boleta);
                items.add(item);
                
                precioNeto += item.getTotal();
            }
            
            boleta.setItems(items);
            
            Totales totales = new Totales();
            int iva = (int) (precioNeto * 0.19);
            totales.setPrecioNeto(precioNeto);
            totales.setIva(iva);
            totales.setTotal(precioNeto + iva);
            totales.setBoleta(boleta);
            boleta.setTotales(totales);

            MedioPago medioPago = new MedioPago();
            medioPago.setTipo(faker.options().option("Tarjeta de Crédito", "Transferencia", "Efectivo"));
            medioPago.setMontoPagado(totales.getTotal());
            medioPago.setBoleta(boleta);
            boleta.setMediopago(medioPago);

            boletaRepository.save(boleta);
        }
    }
}
