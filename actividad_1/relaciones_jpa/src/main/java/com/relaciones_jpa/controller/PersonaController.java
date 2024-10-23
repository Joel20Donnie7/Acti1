package com.relaciones_jpa.controller;

import com.relaciones_jpa.model.Persona;
import com.relaciones_jpa.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/personas")
public class PersonaController {

    @Autowired
    private PersonaService personaService;

    @GetMapping
    public List<Persona> getAllPersonas() {
        return personaService.getAllPersonas();
    }

    @GetMapping("/{id}")
    public Optional<Persona> getPersonaById(@PathVariable Long id) {
        return personaService.getPersonaById(id);
    }

    @PostMapping
    public Persona savePersona(@RequestBody Persona persona) {
        return personaService.savePersona(persona);
    }

    @DeleteMapping("/{id}")
    public void deletePersona(@PathVariable Long id) {
        personaService.deletePersona(id);
    }
}
