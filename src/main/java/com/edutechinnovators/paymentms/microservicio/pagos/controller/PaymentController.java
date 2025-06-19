package com.edutechinnovators.paymentms.microservicio.pagos.controller;

import com.edutechinnovators.paymentms.microservicio.pagos.model.Boleta;
import com.edutechinnovators.paymentms.microservicio.pagos.service.BoletaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pagos")
public class PaymentController {

    @Autowired
    private BoletaService boletaService;

    @GetMapping
    public List<Boleta> getAllBoletas() {
        return boletaService.findAll();
    }

    @GetMapping("/{folio}")
    public ResponseEntity<Boleta> getBoletaByFolio(@PathVariable Integer folio) {
        Boleta boleta = boletaService.findByFolio(folio);
        if (boleta != null) {
            return ResponseEntity.ok(boleta);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Boleta createBoleta(@RequestBody Boleta boleta) {
        return boletaService.save(boleta);
    }

    @DeleteMapping("/{folio}")
    public ResponseEntity<Void> deleteBoleta(@PathVariable Integer folio) {
        boolean deleted = boletaService.deleteByFolio(folio);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
