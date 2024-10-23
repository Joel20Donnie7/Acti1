package com.relaciones_jpa.service;

import com.relaciones_jpa.model.Pasaporte;
import com.relaciones_jpa.repository.PasaporteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PasaporteService {

    @Autowired
    private PasaporteRepository pasaporteRepository;

    public List<Pasaporte> getAllPasaportes() {
        return pasaporteRepository.findAll();
    }

    public Optional<Pasaporte> getPasaporteById(Long id) {
        return pasaporteRepository.findById(id);
    }

    public Pasaporte savePasaporte(Pasaporte pasaporte) {
        return pasaporteRepository.save(pasaporte);
    }

    public void deletePasaporte(Long id) {
        pasaporteRepository.deleteById(id);
    }
}
