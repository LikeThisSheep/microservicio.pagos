package com.edutechinnovators.paymentms.microservicio.pagos.service;

import com.edutechinnovators.paymentms.microservicio.pagos.model.Boleta;
import com.edutechinnovators.paymentms.microservicio.pagos.repository.BoletaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoletaService {

    @Autowired
    private BoletaRepository boletaRepository;

    public List<Boleta> findAll() {
        return boletaRepository.findAll();
    }

    public Boleta findByFolio(Integer folio) {
        return boletaRepository.findByFolio(folio);
    }

    public Boleta save(Boleta boleta) {
        return boletaRepository.save(boleta);

    }

    public boolean deleteByFolio(Integer folio) {
        Boleta boleta = boletaRepository.findByFolio(folio);
        if (boleta != null) {
            boletaRepository.delete(boleta);
            return true;
    }
        return false;
    }


        }
        
