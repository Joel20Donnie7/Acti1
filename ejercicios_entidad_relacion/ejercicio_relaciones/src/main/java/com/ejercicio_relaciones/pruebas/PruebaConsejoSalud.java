package com.ejercicio_relaciones.pruebas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.ejercicio_relaciones.entities.ConsejoSalud;
import com.ejercicio_relaciones.repositories.ConsejoSaludRepository;

@Component
public class PruebaConsejoSalud implements CommandLineRunner {

    @Autowired
    private ConsejoSaludRepository consejoSaludRepository;

    @Override
    public void run(String... args) throws Exception {
        // Crear y guardar un nuevo Consejo de Salud
        ConsejoSalud consejo = new ConsejoSalud();
        consejo.setTitulo("Importancia de la Hidratación");
        consejo.setDescripcion("Es fundamental beber al menos 2 litros de agua al día para mantener una buena salud.");
        consejoSaludRepository.save(consejo);

        // Listar todos los Consejos de Salud
        System.out.println("Lista de Consejos de Salud:");
        for (ConsejoSalud c : consejoSaludRepository.findAll()) {
            System.out.println("Título: " + c.getTitulo() + ", Descripción: " + c.getDescripcion());
        }

        // Eliminar el consejo creado
        consejoSaludRepository.delete(consejo);
    }
}
