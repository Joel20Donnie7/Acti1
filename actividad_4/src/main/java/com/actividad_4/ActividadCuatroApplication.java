package com.actividad_4;

import com.actividad_4.model.Categoria;
import com.actividad_4.model.Ejercicio;
import com.actividad_4.model.Rutina;
import com.actividad_4.service.CategoriaService;
import com.actividad_4.service.EjercicioService;
import com.actividad_4.service.RutinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class ActividadCuatroApplication implements CommandLineRunner {

    @Autowired
    private CategoriaService categoriaService;

    @Autowired
    private EjercicioService ejercicioService;

    @Autowired
    private RutinaService rutinaService;

    public static void main(String[] args) {
        SpringApplication.run(ActividadCuatroApplication.class, args);
    }

    @Override
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

        // Ejecución de las consultas para visualizar los resultados
        List<Ejercicio> ejercicios1 = categoriaService.getEjerciciosByCategoriaNombre("Fuerza");
        System.out.println("Ejercicios en la categoría 'Fuerza': " + ejercicios1);

        List<Rutina> rutinas2 = rutinaService.getRutinasByEjercicioNombre("Flexiones");
        System.out.println("Rutinas que contienen 'Flexiones': " + rutinas2);

        List<String> categorias3 = categoriaService.getCategoriasConMasDeUnEjercicio();
        System.out.println("Categorías con más de un ejercicio: " + categorias3);

        List<Ejercicio> ejercicios4 = ejercicioService.getEjerciciosByCategoriaNombrePattern("F%");
        System.out.println("Ejercicios en categorías que empiezan con 'F': " + ejercicios4);

        List<Rutina> rutinas5 = rutinaService.getRutinasByEjercicioTipo("Gimnasio");
        System.out.println("Rutinas que contienen ejercicios de 'Gimnasio': " + rutinas5);
    }
}
