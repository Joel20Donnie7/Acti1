package com.ejercicio_relaciones.pruebas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.ejercicio_relaciones.entities.PlanAlimentacion;
import com.ejercicio_relaciones.repositories.PlanAlimentacionRepository;

@Component
public class PruebaPlanAlimentacion implements CommandLineRunner {

    @Autowired
    private PlanAlimentacionRepository planAlimentacionRepository;

    @Override
    public void run(String... args) throws Exception {
        // Crear y guardar un Plan de Alimentación
        PlanAlimentacion plan = new PlanAlimentacion();
        plan.setNombre("Plan de Pérdida de Peso");
        plan.setDescripcion("Plan de alimentación para ayudar a perder peso de forma saludable.");
        plan.setObjetivo("Pérdida de peso");
        planAlimentacionRepository.save(plan);

        // Listar todos los Planes de Alimentación
        System.out.println("Lista de Planes de Alimentación:");
        for (PlanAlimentacion p : planAlimentacionRepository.findAll()) {
            System.out.println("Plan: " + p.getNombre() + ", Objetivo: " + p.getObjetivo());
        }

        // Eliminar el plan
        planAlimentacionRepository.delete(plan);
    }
}