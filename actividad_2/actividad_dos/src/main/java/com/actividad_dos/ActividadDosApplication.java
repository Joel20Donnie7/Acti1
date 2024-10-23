package com.actividad_dos;

import com.actividad_dos.model.Categoria;
import com.actividad_dos.model.Ejercicio;
import com.actividad_dos.model.Rutina;
import com.actividad_dos.service.CategoriaService;
import com.actividad_dos.service.EjercicioService;
import com.actividad_dos.service.RutinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ActividadDosApplication {

    @Autowired
    private CategoriaService categoriaService;

    @Autowired
    private EjercicioService ejercicioService;

    @Autowired
    private RutinaService rutinaService;


    public static void main(String[] args) {
        SpringApplication.run(ActividadDosApplication.class, args);
    }

    public void run(String... args) throws Exception {
        // Creación y guardado de una categoría
        Categoria categoria = new Categoria("Fuerza");
        categoriaService.saveCategoria(categoria);

        // Creación de ejercicios y asignación de la categoría
        Ejercicio ejercicio1 = new Ejercicio("Press de banca", "Gimnasio", categoria);
        Ejercicio ejercicio2 = new Ejercicio("Sentadilla", "Gimnasio", categoria);

        // Guardar los ejercicios
        ejercicioService.saveEjercicio(ejercicio1);
        ejercicioService.saveEjercicio(ejercicio2);

        // Creación y guardado de ejercicios para rutina
        Ejercicio ejercicio3 = new Ejercicio("Flexiones", "Casa");
        Ejercicio ejercicio4 = new Ejercicio("Sentadillas", "Gimnasio");
        ejercicioService.saveEjercicio(ejercicio3);
        ejercicioService.saveEjercicio(ejercicio4);

        // Creación de una rutina y asignación de ejercicios
        Rutina rutina = new Rutina("Rutina de Fuerza");
        rutina.getEjercicios().add(ejercicio3);
        rutina.getEjercicios().add(ejercicio4);

        // Guardar la rutina
        rutinaService.saveRutina(rutina);
    }


}
