package com.relaciones_jpa.controller;


import com.relaciones_jpa.model.Orden;
import com.relaciones_jpa.service.OrdenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ordenes")
public class OrdenController {

    @Autowired
    private OrdenService ordenService;

    @GetMapping
    public List<Orden> getAllOrdenes() {
        return ordenService.getAllOrdenes();
    }

    @GetMapping("/{id}")
    public Optional<Orden> getOrdenById(@PathVariable Long id) {
        return ordenService.getOrdenById(id);
    }

    @PostMapping
    public Orden saveOrden(@RequestBody Orden orden) {
        return ordenService.saveOrden(orden);
    }

    @DeleteMapping("/{id}")
    public void deleteOrden(@PathVariable Long id) {
        ordenService.deleteOrden(id);
    }
}

