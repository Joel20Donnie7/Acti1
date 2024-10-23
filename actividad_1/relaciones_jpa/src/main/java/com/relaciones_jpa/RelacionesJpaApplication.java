package com.relaciones_jpa;

import com.relaciones_jpa.model.Orden;
import com.relaciones_jpa.model.Pasaporte;
import com.relaciones_jpa.model.Persona;
import com.relaciones_jpa.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;

@SpringBootApplication
public class RelacionesJpaApplication implements CommandLineRunner {

    @Autowired
    private PersonaService personaService;

    public static void main(String[] args) {
        SpringApplication.run(RelacionesJpaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // Creación y guardado de un pasaporte
        Pasaporte pasaporte = new Pasaporte("A123456");
        personaService.savePasaporte(pasaporte);

        // Creación de una persona y asignación del pasaporte
        Persona persona = new Persona("Juan Perez");
        persona.setPasaporte(pasaporte);

        // Creación de órdenes y asignación a la persona
        Orden orden1 = new Orden("Compra de laptop", persona);
        Orden orden2 = new Orden("Compra de teléfono", persona);

        // Inicialización de la lista de órdenes
        persona.setOrdenes(new ArrayList<>());
        persona.getOrdenes().add(orden1);
        persona.getOrdenes().add(orden2);

        // Guardar la persona
        personaService.savePersona(persona);
    }
}
