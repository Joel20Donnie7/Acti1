package com.relaciones_jpa.service;

import com.relaciones_jpa.model.Pasaporte;
import com.relaciones_jpa.model.Persona;
import com.relaciones_jpa.repository.PasaporteRepository;
import com.relaciones_jpa.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaService {

    @Autowired
    private PersonaRepository personaRepository;


    public List<Persona> getAllPersonas() {
        return personaRepository.findAll();
    }

    public Optional<Persona> getPersonaById(Long id) {
        return personaRepository.findById(id);
    }

    public Persona savePersona(Persona persona) {
        return personaRepository.save(persona);
    }

    public void deletePersona(Long id) {
        personaRepository.deleteById(id);
    }

    @Autowired
    private PasaporteRepository pasaporteRepository;

    public void savePasaporte(Pasaporte pasaporte) {
        pasaporteRepository.save(pasaporte);
    }



}
