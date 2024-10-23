package com.relaciones_jpa.controller;

import com.relaciones_jpa.model.Pasaporte;
import com.relaciones_jpa.service.PasaporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pasaportes")
public class PasaporteController {

    @Autowired
    private PasaporteService pasaporteService;

    @GetMapping
    public List<Pasaporte> getAllPasaportes() {
        return pasaporteService.getAllPasaportes();
    }

    @GetMapping("/{id}")
    public Optional<Pasaporte> getPasaporteById(@PathVariable Long id) {
        return pasaporteService.getPasaporteById(id);
    }

    @PostMapping
    public Pasaporte savePasaporte(@RequestBody Pasaporte pasaporte) {
        return pasaporteService.savePasaporte(pasaporte);
    }

    @DeleteMapping("/{id}")
    public void deletePasaporte(@PathVariable Long id) {
        pasaporteService.deletePasaporte(id);
    }
}
