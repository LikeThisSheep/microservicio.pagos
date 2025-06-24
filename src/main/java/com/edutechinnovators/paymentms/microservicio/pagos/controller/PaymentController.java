package com.edutechinnovators.paymentms.microservicio.pagos.controller;

import com.edutechinnovators.paymentms.microservicio.pagos.model.Boleta;
import com.edutechinnovators.paymentms.microservicio.pagos.service.BoletaService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pagos")
@Tag(name = "Gestión de Boletas", description = "API para operaciones CRUD de boletas")
public class PaymentController {

    @Autowired
    private BoletaService boletaService;

    @Operation(summary = "Obtener todas las boletas", description = "Devuelve una lista con todas las boletas existentes.")
    @ApiResponse(responseCode = "200", description = "Lista de boletas obtenida con éxito.")
    @GetMapping
    public List<Boleta> getAllBoletas() {
        return boletaService.findAll();
    }

    @Operation(summary = "Obtener una boleta por su folio", description = "Busca y devuelve una boleta específica a partir de su folio único.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Boleta encontrada con éxito."),
        @ApiResponse(responseCode = "404", description = "No se encontró una boleta con el folio especificado.")
    })
    @GetMapping("/{folio}")
    public ResponseEntity<Boleta> getBoletaByFolio(@Parameter(description = "Folio de la boleta a buscar.", required = true, example = "101") @PathVariable Integer folio) {
        Boleta boleta = boletaService.findByFolio(folio);
        if (boleta != null) {
            return ResponseEntity.ok(boleta);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Crear una nueva boleta", description = "Crea y guarda una nueva boleta en la base de datos a partir de los datos proporcionados en el cuerpo de la solicitud.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Boleta creada con éxito. El cuerpo de la respuesta contiene la boleta guardada con su folio asignado.")
    })
    @PostMapping
    public Boleta createBoleta(@RequestBody Boleta boleta) {
        return boletaService.save(boleta);
    }

    @Operation(summary = "Eliminar una boleta por su folio", description = "Elimina una boleta de la base de datos utilizando su folio.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "204", description = "Boleta eliminada con éxito."),
        @ApiResponse(responseCode = "404", description = "No se encontró una boleta con el folio especificado para eliminar.")
    })
    @DeleteMapping("/{folio}")
    public ResponseEntity<Void> deleteBoleta(@Parameter(description = "Folio de la boleta a eliminar.", required = true, example = "101") @PathVariable Integer folio) {
        boolean deleted = boletaService.deleteByFolio(folio);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
