package com.ejercicio_relaciones.pruebas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.ejercicio_relaciones.entities.Ejercicio;
import com.ejercicio_relaciones.repositories.EjercicioRepository;

@Component
public class PruebaEjercicio implements CommandLineRunner {

    @Autowired
    private EjercicioRepository ejercicioRepository;

    @Override
    public void run(String... args) throws Exception {
        // Crear y guardar un nuevo Ejercicio
        Ejercicio ejercicio = new Ejercicio();
        ejercicio.setNombre("Flexiones");
        ejercicio.setTipo("Casa");
        ejercicio.setDificultad("Medio");
        ejercicio.setDescripcion("Ejercicio para trabajar el pecho y los brazos.");
        ejercicioRepository.save(ejercicio);

        // Listar todos los Ejercicios
        System.out.println("Lista de Ejercicios:");
        for (Ejercicio e : ejercicioRepository.findAll()) {
            System.out.println("Ejercicio: " + e.getNombre() + ", Tipo: " + e.getTipo());
        }

        // Eliminar el ejercicio
        ejercicioRepository.delete(ejercicio);
    }
}