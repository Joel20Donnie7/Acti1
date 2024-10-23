package com.ejercicio_relaciones.pruebas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.ejercicio_relaciones.entities.Meditacion;
import com.ejercicio_relaciones.repositories.MeditacionRepository;

@Component
public class PruebaMeditacion implements CommandLineRunner {

    @Autowired
    private MeditacionRepository meditacionRepository;

    @Override
    public void run(String... args) throws Exception {
        // Crear y guardar una nueva Meditación
        Meditacion meditacion = new Meditacion();
        meditacion.setNombre("Meditación para la paz interior");
        meditacion.setDuracion(20); // Duración en minutos
        meditacion.setDescripcion("Meditación guiada para encontrar la paz interior.");
        meditacionRepository.save(meditacion);

        // Listar todas las Meditaciones
        System.out.println("Lista de Meditaciones:");
        for (Meditacion m : meditacionRepository.findAll()) {
            System.out.println("Meditación: " + m.getNombre() + ", Duración: " + m.getDuracion() + " minutos");
        }

        // Eliminar la meditación creada
        meditacionRepository.delete(meditacion);
    }
}
