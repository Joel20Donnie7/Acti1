package com.relaciones_jpa.service;

import com.relaciones_jpa.model.Orden;
import com.relaciones_jpa.repository.OrdenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrdenService {

    @Autowired
    private OrdenRepository ordenRepository;

    public List<Orden> getAllOrdenes() {
        return ordenRepository.findAll();
    }

    public Optional<Orden> getOrdenById(Long id) {
        return ordenRepository.findById(id);
    }

    public Orden saveOrden(Orden orden) {
        return ordenRepository.save(orden);
    }

    public void deleteOrden(Long id) {
        ordenRepository.deleteById(id);
    }
}
